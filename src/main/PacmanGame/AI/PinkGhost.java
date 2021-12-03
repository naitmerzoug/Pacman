package PacmanGame.AI;

import Moteurs.core.CoreEngine;
import Moteurs.physic.Type;
import PacmanGame.AI.Ghost;

import java.io.File;

public class PinkGhost extends Ghost {
    public PinkGhost(double x, double y, CoreEngine coreEngine) {

        super(10, x, y, coreEngine);
        coreEngine.createAndAddEntity(Type.SOLID, x, y, 3, 3, 1, new File("src/main/Pacman/Images/pink-ghost.png"));

    }
}
