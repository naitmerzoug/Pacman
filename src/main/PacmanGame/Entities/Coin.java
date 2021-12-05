package PacmanGame.Entities;

import Moteurs.core.CoreEngine;
import Moteurs.core.CoreEntity;
import Moteurs.physic.Type;

import java.io.File;

/**
 * Pièce du jeu
 */
public class Coin {
    /**
     * Position X
     */
    private final double x;

    /**
     * Position Y
     */
    private final double y;

    /**
     * Moteur noyau
     */
    public CoreEngine coreEngine;

    private final CoreEntity coreEntity;

    /**
     * Constructeur d'une pièce
     * @param x Position X
     * @param y Position Y
     * @param coreEngine Moteur noyau
     */
    public Coin(double x, double y, CoreEngine coreEngine)
    {
        this.x = x;
        this.y = y;
        this.coreEngine = coreEngine;
        coreEntity = coreEngine.createAndAddEntity(Type.SOFT, x, y,2,4,0, new File("/PacmanGame/Images/coin.png"));
    }

    // Getters

    public double getX() { return x; }

    public double getY() { return y; }

    public CoreEngine getCoreEngine() {
        return coreEngine;
    }

    public CoreEntity getCoreEntity() {
        return coreEntity;
    }

    // Setters

    public void setCoreEngine(CoreEngine coreEngine) {
        this.coreEngine = coreEngine;
    }


}
