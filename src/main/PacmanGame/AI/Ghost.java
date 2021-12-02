package PacmanGame.AI;

import Moteurs.core.CoreEngine;
import Moteurs.*;
import Moteurs.physic.DIRECTION;

public abstract class Ghost {


    public static final double basicSpeed = 1;
    public static final double scaredSpeed = 1.5;
    public static final double deathSpeed= 3;


    protected double initialX;
    protected double initialY;
    private boolean isVulnerable;
    private CoreEngine coreEngine;

    public enum State{
        TRACK,
        SCARED,
        DEAD,
        NULL
    }


    protected State state = State.NULL;

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


    public boolean isScared(){
        return this.state == State.SCARED;
    }
}
