package PacmanGame.AI;

import Moteurs.core.CoreEngine;

public abstract class Ghost {
    private double initialX;
    private double initialY;
    private double speed;
    private boolean isVulnerable;
    private CoreEngine coreEngine;

    public Ghost(int initialX, int initialY, CoreEngine coreEngine)
    {
        this.initialX = initialX;
        this.initialY = initialY;
        this.isVulnerable = false;
        this.coreEngine = coreEngine;
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
