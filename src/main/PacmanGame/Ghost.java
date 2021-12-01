package PacmanGame;

import Moteurs.core.CoreEngine;

public class Ghost {
    private int x, y, speed;
    private boolean isVulnerable;
    private CoreEngine coreEngine;

    public Ghost(int x, int y, CoreEngine coreEngine)
    {
        this.x = x;
        this.y = y;
        this.isVulnerable = false;
        this.coreEngine = coreEngine;
    }

    //Getters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVulnerable() {
        return isVulnerable;
    }

    public CoreEngine getCoreEngine() {
        return coreEngine;
    }

    // Setters

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVulnerable(boolean vulnerable) {
        this.isVulnerable = vulnerable;
         //if vulnerable true, va plus lentement
    }

    public void setCoreEngine(CoreEngine coreEngine) {
        this.coreEngine = coreEngine;
    }

}
