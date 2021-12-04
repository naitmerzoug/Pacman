package PacmanGame.Entities;

import Moteurs.core.CoreEngine;
import Moteurs.physic.Type;

import java.io.File;

public class Coin {
    private double x, y;
    //boolean canEat = true;
    public CoreEngine coreEngine;

    public Coin(double x, double y, CoreEngine coreEngine)
    {
        this.x = x;
        this.y = y;
        this.coreEngine = coreEngine;
        coreEngine.createAndAddEntity(Type.SOLID, this.x, this.y, 2, 4, 0, new File("src/main/Pacman/Images/coin.png"));
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
