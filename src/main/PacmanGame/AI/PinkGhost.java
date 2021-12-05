package PacmanGame.AI;

import Moteurs.core.CoreEngine;
import Moteurs.physic.Type;
import PacmanGame.AI.Ghost;

import java.io.File;

/**
 * Fantôme rose
 */
public class PinkGhost extends Ghost {
    public PinkGhost(double x, double y, CoreEngine coreEngine) {

        super(10, x, y, coreEngine);
        coreEngine.createAndAddEntity(Type.SOLID, x, y, 3, 3, 0.25, new File("/PacmanGame/Images/pink-ghost.png"));

    }
}
