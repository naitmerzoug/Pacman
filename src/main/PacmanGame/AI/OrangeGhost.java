package PacmanGame.AI;

import Moteurs.core.CoreEngine;
import Moteurs.physic.Type;
import PacmanGame.AI.Ghost;

import java.io.File;

public class OrangeGhost extends Ghost {


    private double x;
    private double y;

    public OrangeGhost(double x, double y, CoreEngine coreEngine) {
        super(11, x, y, coreEngine);
        coreEngine.createAndAddEntity(Type.SOLID, x, y, 3, 3, 1, new File("src/main/Pacman/Images/orange-ghost.png"));

    }

}
