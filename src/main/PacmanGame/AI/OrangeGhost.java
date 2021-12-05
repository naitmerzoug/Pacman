package PacmanGame.AI;

import Moteurs.core.CoreEngine;
import Moteurs.physic.Type;
import PacmanGame.AI.Ghost;

import java.io.File;

/**
 * Fantôme orange
 */
public class OrangeGhost extends Ghost {

    private double x;
    private double y;

    public OrangeGhost(double x, double y, CoreEngine coreEngine) {
        super(11, x, y, coreEngine);
        coreEngine.createAndAddEntity(Type.SOLID, x, y, 3, 3, 0.25, new File("/PacmanGame/Images/orange-ghost.png"));

    }

}
