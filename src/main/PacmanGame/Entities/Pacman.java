package PacmanGame.Entities;

import Moteurs.core.CoreEngine;
import Moteurs.physic.DIRECTION;
import Moteurs.physic.Type;
import PacmanGame.Direction;

import java.io.File;

public class Pacman {
    private int x, y;
    private int speed;
    private boolean isDead;
    private boolean isInvincible;
    private CoreEngine coreEngine;

    private Direction currentDirection;

    public Pacman(int x, int y, CoreEngine coreEngine)
    {
        this.x = x;
        this.y = y;
        this.isDead = false;
        this.isInvincible = false;
        this.coreEngine = coreEngine;
        this.currentDirection = null;

        coreEngine.createAndAddEntity(Type.SOLID,x * 1.0, y * 1.0,10,10,1,new File("src/main/Pacman/Images/pacman.png"));
    }

    public boolean isAlive() {
        return !isDead;
    }

    // Setters

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void setInvincible(boolean invincible) {
        isInvincible = invincible;
    }

    public void setCoreEngine(CoreEngine coreEngine) {
        this.coreEngine = coreEngine;
    }


    public void setDirection(Direction direction) {
        currentDirection = direction;
    }

    //Getters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean getDead() { return isDead; }

    public boolean getInvincible() {
        return isInvincible;
    }

    public CoreEngine getCoreEngine() {
        return coreEngine;
    }

    public Direction getCurrentDirections() { return currentDirection; }

}
