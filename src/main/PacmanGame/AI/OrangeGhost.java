package PacmanGame.AI;

import Moteurs.core.CoreEngine;
import PacmanGame.AI.Ghost;

public class OrangeGhost extends Ghost {

    private int id;
    private double initialX;
    private double initialY;

    public OrangeGhost(int id, double initialX, double initialY, CoreEngine coreEngine) {
        super(id, initialX, initialY, coreEngine);
    }

}
