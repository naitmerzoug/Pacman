package PacmanGame.AI;

import Moteurs.core.CoreEngine;

/**
 * Fantôme
 */
public abstract class Ghost {


    public static final double speed= 1.7;

    /**
     * Position X
     */
    protected double initialX;
    /**
     * Position Y
     */
    protected double initialY;
    /**
     * True si le fantôme est vulnérable
     */
    private boolean isVulnerable;
    /**
     * Moteur noyau
     */
    private CoreEngine coreEngine;
    /**
     * Identifiant unique
     */
    private int id;

    public enum State{
        TRACK,
        SCARED,
        DEAD,
        NULL
    }
    /**
     * Etat
     */
    protected State state = State.NULL;

    /**
     * Constructeur d'un fantôme
     * @param initialX Position X
     * @param initialY Position Y
     * @param coreEngine Moteur noyau
     */
    public Ghost(int id, double initialX, double initialY, CoreEngine coreEngine)
    {
        this.initialX = initialX;
        this.initialY = initialY;
        this.isVulnerable = false;
        this.coreEngine = coreEngine;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    //Getters


    public double getInitialX() {
        return initialX;
    }

    public double getInitialY() {
        return initialY;
    }

    public boolean isVulnerable() {
        return isVulnerable;
    }

    public CoreEngine getCoreEngine() {
        return coreEngine;
    }

    // Setters


    public void setInitialX(double initialX) {
        this.initialX = initialX;
    }

    public void setInitialY(double initialY) {
        this.initialY = initialY;
    }

    public void setVulnerable(boolean vulnerable) {
        this.isVulnerable = vulnerable;
         //if vulnerable true, va plus lentement
    }

    public void setCoreEngine(CoreEngine coreEngine) {
        this.coreEngine = coreEngine;
    }

}
