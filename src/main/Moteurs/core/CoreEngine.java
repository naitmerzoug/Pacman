package Moteurs.core;

import Moteurs.graphic.GraphicEngine;
import Moteurs.inout.IOEngine;
import Moteurs.physic.PhysicEngine;
import Moteurs.physic.PhysicEntity;
import Moteurs.physic.Type;
import Moteurs.sound.SoundEngine;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Noyau du jeu
 * Doit contenir un accès à tous les autres moteurs
 */
public class CoreEngine {

    /**
     * Hauteur et largeur de l'espace graphique
     */
    private int GraphicHeight, GraphicWidth;

    private final Map<String, Runnable> events = new HashMap<>();

    /**
     * Hauteur et largeur de l'espace physique
     */
    private double PhysicHeight, PhysicWidth;
    private IOEngine ioEngine;
    private GraphicEngine graphicEngine;
    private PhysicEngine physicEngine;
    private SoundEngine soundEngine;
    private ConcurrentMap<Integer,CoreEntity> entities;
    public static int nbEntities;

    public CoreEngine(double physicHeight, double physicWidth, int graphicHeight, int graphicWidth){

        // Tailles des espaces physiques et graphiques
        this.PhysicHeight = physicHeight;
        this.PhysicWidth = physicWidth;
        this.GraphicHeight = graphicHeight;
        this.GraphicWidth = graphicWidth;

        // Attributs
        nbEntities = 0;

        // Moteurs
        this.ioEngine = new IOEngine();
        this.graphicEngine = new GraphicEngine(750,500, Color.BLACK,"name");
        this.physicEngine = new PhysicEngine();
        this.soundEngine = new SoundEngine();
        this.entities = new ConcurrentHashMap<>();
    }

    /**
     * Création d'une entité noyau
     */
    public CoreEntity addEntity(Type type, double x, double y, double length, double width, int speed){

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
        //JLabel g = new GraphicEntity(ConvertPhysictoGraphic(x),ConvertPhysictoGraphicOrd(y),ConvertPhysictoGraphic(length),ConvertPhysictoGraphic(width));
        //e.setGraphicEntity(g);
        //this.getGraphicEngine().add_entity();

        entities.put(e.getId(),e);

        return e;
    }

    /**
     * Supprime une entité noyau
     */
    public void removeEntity(CoreEntity e){
        entities.remove(e.getId());
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

    public IOEngine getIoEngine() {
        return ioEngine;
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

}