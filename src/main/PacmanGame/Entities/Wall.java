package PacmanGame.Entities;

import Moteurs.core.CoreEngine;
import Moteurs.physic.Type;

import java.io.File;

public class Wall {
    private double x, y;
    private CoreEngine coreEngine;

    public Wall(double x, double y, double height, double width, CoreEngine coreEngine)
    {
        this.x = x;
        this.y = y;
        this.coreEngine = coreEngine;

        coreEngine.createAndAddEntity(Type.SOLID,x,y,height,width,0,new File("src/main/Pacman/Images/wall.png"));
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
