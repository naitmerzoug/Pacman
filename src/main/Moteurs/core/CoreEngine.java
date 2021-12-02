package Moteurs.core;

import Moteurs.Game;
import Moteurs.graphic.GraphicEngine;
import Moteurs.physic.PhysicEngine;
import Moteurs.physic.PhysicEntity;
import Moteurs.physic.Type;
import Moteurs.sound.SoundEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Noyau du jeu
 * Doit contenir un accès à tous les autres moteurs
 */
public class CoreEngine implements CoreEngineEvent {
    private Game game;

    /**
     * Hauteur et largeur de l'espace graphique
     */
    private int GraphicHeight, GraphicWidth;

    private final Map<String, Runnable> events = new HashMap<>();

    /**
     * Hauteur et largeur de l'espace physique
     */
    private double PhysicHeight, PhysicWidth;
    private GraphicEngine graphicEngine;
    private PhysicEngine physicEngine;
    private SoundEngine soundEngine;
    private ConcurrentMap<Integer,CoreEntity> entities;
    public static int nbEntities;
    private volatile boolean pause = false;

    public CoreEngine(double physicHeight, double physicWidth, int graphicHeight, int graphicWidth){

        // Tailles des espaces physiques et graphiques
        this.PhysicHeight = physicHeight;
        this.PhysicWidth = physicWidth;
        this.GraphicHeight = graphicHeight;
        this.GraphicWidth = graphicWidth;

        // Attributs
        nbEntities = 0;

        // Moteurs
        this.graphicEngine = new GraphicEngine(graphicWidth, graphicHeight, Color.BLACK,"Pacman");
        graphicEngine.setCoreEngine(this);
        this.physicEngine = new PhysicEngine();
        this.soundEngine = new SoundEngine();
        this.entities = new ConcurrentHashMap<>();
    }

    public void setGame(Game game){
        this.game = game;
    }

    public void run() {
        graphicEngine.run();
    }

    /**
     * Création d'une entité noyau
     */
    public CoreEntity createAndAddEntity(Type type, double x, double y, int length, int width, int speed, File file){

        CoreEntity e = new CoreEntity();
        if(e.getId()==0 || entities.containsKey(e.getId())){
            nbEntities++;
            e.setId(nbEntities);
        }

        // Création côté physique
        PhysicEntity p = new PhysicEntity(e.getId(), type, x, y, length, width, speed);
        e.setPhysicEntity(p);
        this.getPhysicEngine().createEntity(e.getPhysicEntity());

        // Création côté graphique
        JLabel g = this.getGraphicEngine().createEntity( length, width, file);
        this.getGraphicEngine().addEntity(g, ConvertPhysictoGraphic(x), ConvertPhysictoGraphicOrd(y));
        e.setGraphicEntity(g);

        entities.put(e.getId(),e);

        return e;
    }

    /**
     * Supprime une entité noyau
     */
    public void removeEntity(CoreEntity e){

        this.getPhysicEngine().removeEntity(e.getPhysicEntity()); // suppression physique
        this.getGraphicEngine().getjPanel().remove(e.getGraphicEntity()); // suppression graphique
        entities.remove(e.getId());  // suppression du noyau
    }

    /**
     * Converti des coordonnées de l'espace physique en espace graphique
     * Valable pour l'axe des abscisses et pour les tailles en général
     */
    public int ConvertPhysictoGraphic(double x)
    {
        int graphicWidth = this.getGraphicWidth();
        double physicWidth = this.getPhysicWidth();
        return (int) ((graphicWidth * x) / physicWidth);

    }

    /**
     * Converti des coordonnées de l'espace physique en espace graphique pour l'axe des ordonnées
     */
    public int ConvertPhysictoGraphicOrd(double y)
    {
        int graphicHeight = this.getGraphicHeight();
        double physicHeight = this.getPhysicHeight();
        return (int) (-(graphicHeight * y) / physicHeight);

    }

    public void addEvent(String name, Runnable event){
        events.put(name, event);
    }


    // Getters

    public GraphicEngine getGraphicEngine() {
        return graphicEngine;
    }

    public PhysicEngine getPhysicEngine() {
        return physicEngine;
    }

    public SoundEngine getSoundEngine() {
        return soundEngine;
    }

    public static int getNbEntities() {
        return nbEntities;
    }

    public ConcurrentMap<Integer, CoreEntity> getEntities() {
        return entities;
    }

    public double getPhysicHeight() { return PhysicHeight; }

    public double getPhysicWidth() { return PhysicWidth; }

    public int getGraphicHeight() { return GraphicHeight; }

    public int getGraphicWidth() { return GraphicWidth; }

    // Setter

    public static void setNbEntities(int nbEntities) {
        CoreEngine.nbEntities = nbEntities;
    }


    public boolean getPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    @Override
    public void sendKeyEvent(KeyEvent keyEvent) {
            game.getKeyEvent(keyEvent);
    }
}