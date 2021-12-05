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
 * Moteur noyau
 */
public class CoreEngine implements CoreEngineEvent {
    /**
     * Interface de jeu
     */
    private Game game;

    /**
     * Hauteur de l'espace graphique
     */
    private final int GraphicHeight;
    /**
     * Largeur de l'espace graphique
     */
    private final int GraphicWidth;

    /**
     * Hauteur de l'espace physique
     */
    private final double PhysicHeight;
    /**
     * Largeur de l'espace physique
     */
    private final double PhysicWidth;

    /**
     * Moteur graphique
     */
    private final GraphicEngine graphicEngine;
    /**
     * Moteur physique
     */
    private final PhysicEngine physicEngine;
    /**
     * Moteur sonore
     */
    private final SoundEngine soundEngine;

    /**
     * Liste des entités noyaux
     */
    private final ConcurrentMap<Integer,CoreEntity> entities;
    /**
     * Nombre d'entités pour l'attribution de l'ID
     */
    public static int nbEntities;

    /**
     * Constructeur du moteur noyau
     * @param gamename Nom du jeu
     * @param physicHeight Hauteur de l'espace physique
     * @param physicWidth Largeur de l'espace physique
     */
    public CoreEngine(String gamename, double physicHeight, double physicWidth){

        // Tailles des espaces physiques et graphiques
        this.PhysicHeight = physicHeight;
        this.PhysicWidth = physicWidth;
        this.GraphicHeight = (int) physicHeight * 10;
        this.GraphicWidth = (int) physicWidth * 10;

        // Attribut
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

    /**
     * Démarre l'interface graphique
     */
    public void run() {
        graphicEngine.run();
    }

    /**
     * Création d'une entité noyau
     * @param type soft or solid
     * @param x position physique en x
     * @param y position physique en y
     * @param height hauteur entité
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
        PhysicEntity p = new PhysicEntity(id, type, x, y, height, width, speed);
        physicEngine.addEntity(p);

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
     * @param e Entité noyau
     */
    public void removeEntity(CoreEntity e){

        this.getPhysicEngine().removeEntity(e.getPhysicEntity()); // suppression physique
        this.getGraphicEngine().getFrame().remove(e.getGraphicEntity()); // suppression graphique
        entities.remove(e.getId());  // suppression de l'entité noyau
    }

    /**
     * Convertir des coordonnées de l'espace physique en espace graphique (abscisses et pour les tailles en général)
     * @param x Position en x
     */
    public int ConvertPhysictoGraphic(double x)
    {
        int graphicWidth = this.getGraphicWidth();
        double physicWidth = this.getPhysicWidth();
        return (int) ((graphicWidth * x) / physicWidth);

    }

    /**
     * Convertir des coordonnées de l'espace physique en espace graphique pour l'axe des ordonnées
     * @param y Position en y
     */
    public int ConvertPhysictoGraphicOrd(double y)
    {
        int graphicHeight = this.getGraphicHeight();
        double physicHeight = this.getPhysicHeight();
        return (int) (-(graphicHeight * y) / physicHeight);

    }

    /**
     * Transmet la touche cliquée
     */
    @Override
    public void sendKeyEvent(KeyEvent keyEvent) {
        game.getKeyEvent(keyEvent);
    }


    /**
     * Déplacement d'une entité
     * @param coreEntity entité noyau
     * @param currentDirection direction
     */
    public void moveEntity(CoreEntity coreEntity, DIRECTION currentDirection) {

        // mouvement physique
        this.getPhysicEngine().move(coreEntity.getPhysicEntity(), currentDirection);
        // repercussion sur le mouvement graphique
        graphicEngine.setPositionEntity(coreEntity.getGraphicEntity(), this.ConvertPhysictoGraphic(coreEntity.getPhysicEntity().getPosX()), this.ConvertPhysictoGraphicOrd(coreEntity.getPhysicEntity().getPosY()));

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



}