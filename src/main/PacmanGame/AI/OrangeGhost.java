package PacmanGame.AI;

import Moteurs.core.CoreEngine;
import PacmanGame.AI.Ghost;

public class OrangeGhost extends Ghost {


    private double initialX;
    private double initialY;

    public OrangeGhost(int initialX, int initialY, CoreEngine coreEngine) {
        super(initialX, initialY, coreEngine);
    }

}
