package Pacman;

import Moteurs.core.CoreEngine;

public class Pacman {
    private int x, y;
    private int speed;
    private boolean isDead;
    private boolean isInvincible;
    private CoreEngine coreEngine;

    public Pacman(int x, int y, CoreEngine coreEngine)
    {
        this.x = x;
        this.y = y;
        this.isDead = false;
        this.isInvincible = false;
        this.coreEngine = coreEngine;
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

    // Getters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean getDead() {
        return isDead;
    }

    public boolean getInvincible() {
        return isInvincible;
    }

    public CoreEngine getCoreEngine() {
        return coreEngine;
    }

}
