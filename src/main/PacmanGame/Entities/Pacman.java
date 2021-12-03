package PacmanGame.Entities;

import Moteurs.core.CoreEngine;
import Moteurs.physic.DIRECTION;
import Moteurs.physic.Type;
import PacmanGame.Direction;

import java.io.File;

public class Pacman {
    private double x, y;
    private double speed;
    private boolean isDead;
    private boolean isInvincible;
    private CoreEngine coreEngine;

    private Direction currentDirection;

    public Pacman(double x, double y, CoreEngine coreEngine)
    {
        this.x = x;
        this.y = y;
        this.isDead = false;
        this.isInvincible = false;
        this.coreEngine = coreEngine;
        this.currentDirection = null;
    }

    public boolean isAlive() {
        return !isDead;
    }

    // Setters

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSpeed(double speed) {
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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getSpeed() {
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
