package PacmanGame;

import Moteurs.core.CoreEngine;
import Moteurs.physic.DIRECTION;

public class Pacman {
    private int x, y;
    private int speed;
    private boolean isDead;
    private boolean isInvincible;
    private CoreEngine coreEngine;

    public enum DIRECTION {UP, RIGHT, LEFT, DOWN}
    private DIRECTION currentDirections;

    public Pacman(int x, int y, CoreEngine coreEngine)
    {
        this.x = x;
        this.y = y;
        this.isDead = false;
        this.isInvincible = false;
        this.coreEngine = coreEngine;
        this.currentDirections = null; // Par défaut quand on crée Pacman il va à droite. Bonne idée?
        //this.coreEngine.createEntity(x, y);
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

    public void setCurrentDirections(DIRECTION direction) {
        this.currentDirections = direction;
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

    public boolean getDead() {
        return isDead;
    }

    public boolean getInvincible() {
        return isInvincible;
    }

    public CoreEngine getCoreEngine() {
        return coreEngine;
    }

    public DIRECTION getCurrentDirections() {
        return currentDirections;
    }
}
