package PacmanGame;

import Moteurs.core.CoreEngine;

public class Coin {
    private int x, y;
    //boolean canEat = true;
    public CoreEngine coreEngine;

    public Coin(int x, int y, CoreEngine coreEngine)
    {
        this.x = x;
        this.y = y;
    }

    // Getters

    public int getX() { return x; }

    public int getY() { return y; }

    public CoreEngine getCoreEngine() {
        return coreEngine;
    }


    // Setters

    public void setCoreEngine(CoreEngine coreEngine) {
        this.coreEngine = coreEngine;
    }


}
