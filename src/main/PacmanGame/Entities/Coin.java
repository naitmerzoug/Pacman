package PacmanGame.Entities;

import Moteurs.core.CoreEngine;

public class Coin {
    private double x, y;
    //boolean canEat = true;
    public CoreEngine coreEngine;

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
