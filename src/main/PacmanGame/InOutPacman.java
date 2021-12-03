package PacmanGame;

import PacmanGame.Entities.Pacman;

import java.awt.event.KeyEvent;

import static Moteurs.physic.DIRECTION.*;

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
            case 38 -> pacman.getCoreEntity().getPhysicEntity().setDirection(UP);
            case 40 -> pacman.getCoreEntity().getPhysicEntity().setDirection(DOWN);
            case 39 -> pacman.getCoreEntity().getPhysicEntity().setDirection(RIGHT);
            case 37 -> pacman.getCoreEntity().getPhysicEntity().setDirection(LEFT);
            case 80 -> main.setPause();
            default -> {
            }
        }
    }

}
