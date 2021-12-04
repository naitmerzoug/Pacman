package PacmanGame.AI;

import Moteurs.core.CoreEngine;
import Moteurs.physic.Type;
import PacmanGame.AI.Ghost;

import java.io.File;

/**
 * Fantôme rouge
 */
public class RedGhost extends Ghost {
    public RedGhost(double x, double y, CoreEngine coreEngine) {

        super(12, x, y, coreEngine);
        coreEngine.createAndAddEntity(Type.SOLID, x, y, 3, 3, 1, new File("/PacmanGame/Images/red-ghost.png"));

    }
}
