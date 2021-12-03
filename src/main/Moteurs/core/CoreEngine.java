package Moteurs.core;

import Moteurs.Game;
import Moteurs.graphic.GraphicEngine;
import Moteurs.physicm.DIRECTION;
import Moteurs.physicm.EnginePhysic;
import Moteurs.physicm.EntityPhysic;
import Moteurs.physicm.Type;
import Moteurs.sound.SoundEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
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
    private EnginePhysic enginePhysic;
    private SoundEngine soundEngine;
    private ConcurrentMap<Integer,CoreEntity> entities;
    public static int nbEntities;
    private volatile boolean pause = false;

    public CoreEngine(String gamename, double physicHeight, double physicWidth){

        // Tailles des espaces physiques et graphiques
        this.PhysicHeight = physicHeight;
        this.PhysicWidth = physicWidth;
        this.GraphicHeight = (int) physicHeight * 10;
        this.GraphicWidth = (int) physicWidth * 10;

        // Attributs
        nbEntities = 0;

        // Moteurs
        this.graphicEngine = new GraphicEngine(this.GraphicWidth, this.GraphicHeight, Color.BLACK, gamename);
        graphicEngine.setCoreEngine(this);
        this.enginePhysic = new EnginePhysic(physicWidth, physicHeight);
        this.soundEngine = new SoundEngine();
        this.entities = new ConcurrentHashMap<>();
    }

    public void move (CoreEntity e){
        EnginePhysic.move(e.getEntityPhysic(), 1);
       // graphicEngine.mooveEntity(e.getGraphicEntity(),);
    }

    public void setGame(Game game){
        this.game = game;
    }

    public void run() {
        graphicEngine.run();
    }

    /**
     * Création d'une entité noyau
     * @param type soft or solid
     * @param x position physic origine gauche haut
     * @param y position physic origine gauche haut
     * @param height largeur entité
     * @param width longueur entité
     * @param speed vitesse entité
     * @param file image entité
     * @return
     */
    public CoreEntity createAndAddEntity(Type type, double x, double y, double height, double width, int speed, File file){

        CoreEntity coreEntity = new CoreEntity();
        if(coreEntity.getId()==0 || entities.containsKey(coreEntity.getId())){
            nbEntities++;
            coreEntity.setId(nbEntities);
        }

        // Création côté physique
        enginePhysic.createAndAddEntity(coreEntity.getId(), x+(width/2), y-(height/2), height, width,type, speed);

        // Création côté graphique

        JPanel entity = graphicEngine.createAndAddEntity(ConvertPhysictoGraphic(x),ConvertPhysictoGraphicOrd(y), ConvertPhysictoGraphic(height), ConvertPhysictoGraphic(width), file);
        //graphicEngine.addEntity(entity, ConvertPhysictoGraphic(x), ConvertPhysictoGraphicOrd(y));
        System.out.println("new entity add");
        coreEntity.setGraphicEntity(entity);
        entities.put(coreEntity.getId(),coreEntity);

        return coreEntity;
    }

    /**
     * Supprime une entité noyau
     */
    public void removeEntity(CoreEntity e){

        this.getEnginePhysic().removeEntity(e.getEntityPhysic()); // suppression physique
        this.getGraphicEngine().getFrame().remove(e.getGraphicEntity()); // suppression graphique
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

    public EnginePhysic getEnginePhysic() {
        return enginePhysic;
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

    public Map<String, Runnable> getEvents() {
        return events;
    }

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

    public void moveAll() {
        for(CoreEntity entity : entities.values()) {
            graphicEngine.setPositionEntity(entity.getGraphicEntity(), entity.getGraphicEntity().getX(), entity.getGraphicEntity().getY());
            System.out.println("moove "+entity.getGraphicEntity().getX()+":"+entity.getGraphicEntity().getY());
        }
    }

    /**
     * Test moove Pacman
     * @param coreEntity
     * @param currentDirection
     * @param v
     */
    public void movePacman(CoreEntity coreEntity, DIRECTION currentDirection, int v) {
        int x = 0, y = 0;
        System.out.println("je bouge");
        switch(currentDirection){
            case UP    -> y= +v;
            case DOWN  -> y= -v;
            case RIGHT -> x= +v;
            case LEFT  -> x= -v;
            default-> x=y;
        }
        graphicEngine.setPositionEntity(coreEntity.getGraphicEntity(), coreEntity.getGraphicEntity().getX()+x,coreEntity.getGraphicEntity().getY()+y);
    }

    // TODO: 03/12/2021
    /*
    public void moveAll2(){
        //Pour toute entitité bouger
        for(CoreEntity coreEntity : entities.values())
            ArrayList<EntityPhysic> coreEntities = enginePhysic.getCollisionsList(coreEntity.getEntityPhysic(),1,1);

    }
*/
    // TODO: 03/12/2021
    public void moveEntity(CoreEntity coreEntity){
        //récupérer list collision
        //tester si vide
            //bouger entity physic + graphix
        //envoyer list à pacmanGame
    }



}