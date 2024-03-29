package PacmanGame.Entities;

import Moteurs.core.CoreEngine;
import Moteurs.core.CoreEntity;
import Moteurs.physic.Type;
import PacmanGame.AI.Ghost;

import java.io.File;

public class Pacman {
    private final CoreEntity coreEntity;
    private double x, y;
    private double speed;
    private boolean isDead;
    private boolean isInvincible;
    private CoreEngine coreEngine;

    public Pacman(double x, double y, CoreEngine coreEngine)
    {
        this.x = x;
        this.y = y;
        this.isDead = false;
        this.isInvincible = false;
        this.coreEngine = coreEngine;
        coreEntity = coreEngine.createAndAddEntity(Type.SOLID,x, y,3,3,1, new File("src/main/Pacman/Images/pacman.png"));
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

    public CoreEntity getCoreEntity() {
        return coreEntity;
    }

    // TODO: 03/12/2021
    public void eatGhost(Ghost ghosts ){

    }

    // TODO: 03/12/2021
    public void eatBonus(CoreEntity coreEntity ){

    }

    // TODO: 03/12/2021
    public void eatCoin(CoreEntity coreEntity ){

    }

    // TODO: 03/12/2021
    public void die(){
        isDead = true;
    }


}
