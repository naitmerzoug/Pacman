package PacmanGame.Entities;

import Moteurs.core.CoreEngine;

/**
 * Pièce du jeu
 */
public class Coin {
    /**
     * Position X
     */
    private double x;

    /**
     * Position Y
     */
    private double y;

    /**
     * Moteur noyau
     */
    public CoreEngine coreEngine;

    /**
     * Constructeur d'une pièce
     * @param x Position X
     * @param y Position Y
     * @param coreEngine Moteur noyau
     */
    public Coin(double x, double y, CoreEngine coreEngine)
    {
        this.x = x;
        this.y = y;
    }

    // Getters

    public double getX() { return x; }

    public double getY() { return y; }

    public CoreEngine getCoreEngine() {
        return coreEngine;
    }


    // Setters

    public void setCoreEngine(CoreEngine coreEngine) {
        this.coreEngine = coreEngine;
    }


}
