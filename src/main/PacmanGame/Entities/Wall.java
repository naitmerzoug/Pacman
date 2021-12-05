package PacmanGame.Entities;

import Moteurs.core.CoreEngine;
import Moteurs.physic.Type;

import java.io.File;

/**
 * Mur du labyrinthe
 */
public class Wall {

    /**
     * Position X
     */
    private final double x;
    /**
     * Position Y
     */
    private final double y;
    /**
     * Moteur noyau
     */
    private CoreEngine coreEngine;

    /**
     * Constructeur d'un mur
     * @param x Position X
     * @param y Position Y
     * @param width Largeur du mur
     * @param height Hauteur du mur
     * @param coreEngine Moteur noyau
     */
    public Wall(double x, double y, double height, double width, CoreEngine coreEngine)
    {
        this.x = x;
        this.y = y;
        this.coreEngine = coreEngine;

        coreEngine.createAndAddEntity(Type.SOLID, x, y, height, width,0, new File("/PacmanGame/Images/wall.png"));
    }

    // Getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public CoreEngine getCoreEngine() {
        return coreEngine;
    }

    // Setters
    public void setCoreEngine(CoreEngine coreEngine) {
        this.coreEngine = coreEngine;
    }

}
