package PacmanGame.Entities;

import Moteurs.core.CoreEngine;
import Moteurs.core.CoreEntity;
import Moteurs.physic.Type;
import java.io.File;

/**
 * Personnage Pacman
 */
public class Pacman {
    /**
     * Entité noyau
     */
    private final CoreEntity coreEntity;
    /**
     * Position X
     */
    private double x;
    /**
     * Position Y
     */
    private double y;
    /**
     * True si Pacman est mort
     */
    private boolean isDead;
    /**
     * True si Pacman a le superpouvoir
     */
    private boolean isInvincible;
    /**
     * Moteur noyau
     */
    private CoreEngine coreEngine;

    /**
     * Constructeur d'un Pacman
     * @param x Position X
     * @param y Position Y
     * @param coreEngine Moteur noyau
     */
    public Pacman(double x, double y, CoreEngine coreEngine)
    {
        this.x = x;
        this.y = y;
        this.isDead = false;
        this.isInvincible = false;
        this.coreEngine = coreEngine;
        coreEntity = coreEngine.createAndAddEntity(Type.SOLID,x, y,3,3,1, new File("/PacmanGame/Images/pacman.png"));
    }

    /**
     * Vérifie si Pacman est vivant
     */
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

    public void setDead(){
        isDead = true;
    }


}
