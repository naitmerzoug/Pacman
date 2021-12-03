package Moteurs.core;

import Moteurs.Game;
import Moteurs.graphic.GraphicEngine;
import Moteurs.physic.DIRECTION;
import Moteurs.physic.PhysicEngine;
import Moteurs.physic.PhysicEntity;
import Moteurs.physic.Type;
import Moteurs.sound.SoundEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
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
     * @param type soft or solid
     * @param x position physic origine gauche haut
     * @param y position physic origine gauche haut
     * @param height largeur entité
     * @param width longueur entité
     * @param speed vitesse entité
     * @param file image entité
     * @return coreEntity entité noyau
     */
    public CoreEntity createAndAddEntity(Type type, double x, double y, double height, double width, double speed, File file){

        // Génération de l'id unique
        nbEntities++;
        int id = nbEntities;

        // Création côté physique
        PhysicEntity p = new PhysicEntity(id, type, x+(width/2), y-(height/2), height, width, speed);
        physicEngine.createEntity(p);

        // Création côté graphique
        JPanel entity = graphicEngine.createAndAddEntity(ConvertPhysictoGraphic(x),ConvertPhysictoGraphicOrd(y), ConvertPhysictoGraphic(height), ConvertPhysictoGraphic(width), file);

        // Création côté noyau
        CoreEntity coreEntity = new CoreEntity();
        coreEntity.setId(id);
        coreEntity.setPhysicEntity(p);
        coreEntity.setGraphicEntity(entity);

        entities.put(coreEntity.getId(),coreEntity);

        return coreEntity;
    }

    /**
     * Supprime une entité noyau
     */
    public void removeEntity(CoreEntity e){

        this.getPhysicEngine().removeEntity(e.getPhysicEntity()); // suppression physique
        this.getGraphicEngine().getFrame().remove(e.getGraphicEntity()); // suppression graphique
        entities.remove(e.getId());  // suppression de l'entité noyau
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


    @Override
    public void sendKeyEvent(KeyEvent keyEvent) {
        game.getKeyEvent(keyEvent);
    }

    public void moveAll() {
        for(CoreEntity entity : entities.values()) {
            graphicEngine.setPositionEntity(entity.getGraphicEntity(), entity.getGraphicEntity().getX(), entity.getGraphicEntity().getY());
        }
    }

    /**
     * Test move entity
     * @param coreEntity
     * @param currentDirection
     * @param step
     */
    public void moveEntity(CoreEntity coreEntity, DIRECTION currentDirection, int step) {
        int x = 0, y = 0;

        this.getPhysicEngine().move(coreEntity.getPhysicEntity(), currentDirection);

        // comme moteur physique, non fonctionnelle, déplacement graphique sinon j'aurai fait :
        // graphicEngine.setPositionEntity(coreEntity.getGraphicEntity(), this.ConvertPhysictoGraphic(x), this.ConvertPhysictoGraphicOrd(y));

        switch(currentDirection){
            case UP    -> y -= step;
            case DOWN  -> y += step;
            case RIGHT -> x += step;
            case LEFT  -> x -= step;
            default-> x = y;
        }
        graphicEngine.setPositionEntity(coreEntity.getGraphicEntity(), coreEntity.getGraphicEntity().getX()+x,coreEntity.getGraphicEntity().getY()+y);
    }

    // Getters

    public GraphicEngine getGraphicEngine() { return graphicEngine;}

    public PhysicEngine getPhysicEngine() { return physicEngine; }

    public SoundEngine getSoundEngine() { return soundEngine; }

    public static int getNbEntities() { return nbEntities;}

    public ConcurrentMap<Integer, CoreEntity> getEntities() { return entities; }

    public double getPhysicHeight() { return PhysicHeight; }

    public double getPhysicWidth() { return PhysicWidth; }

    public int getGraphicHeight() { return GraphicHeight; }

    public int getGraphicWidth() { return GraphicWidth; }

    public boolean getPause() { return pause; }

    // Setter

    public void setPause(boolean pause) { this.pause = pause; }


}