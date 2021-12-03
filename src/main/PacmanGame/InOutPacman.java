package PacmanGame;

import Moteurs.physicm.DIRECTION;
import PacmanGame.Entities.Pacman;

import java.awt.event.KeyEvent;

import static PacmanGame.Direction.*;

public class InOutPacman {

    private final Pacman pacman;
    private final PacmanGame main;

    public InOutPacman(Pacman pacman, PacmanGame main){
        this.pacman = pacman;
        this.main = main;
    }

//    public Direction giveDirection(int keyCode) {
//        Direction direction = null;
//        if (keyCode == 38)
//            direction = direction.UP;
//        else if (keyCode == 40)
//            direction = direction.DOWN;
//        else if (keyCode == 39)
//            direction = direction.RIGHT;
//        else if (keyCode == 37)
//            direction = direction.LEFT;
//
//        return direction;
//    }

    public void receiveKeyEvent(KeyEvent k){
        switch (k.getKeyCode()) {
            case 38 -> pacman.getCoreEntity().getEntityPhysic().setDirection(DIRECTION.UP);
            case 40 -> pacman.getCoreEntity().getEntityPhysic().setDirection(DIRECTION.DOWN);
            case 39 -> pacman.getCoreEntity().getEntityPhysic().setDirection(DIRECTION.RIGHT);
            case 37 -> pacman.getCoreEntity().getEntityPhysic().setDirection(DIRECTION.LEFT);
            case 80 -> main.setPause();
            default -> {
            }
        }
    }

}
