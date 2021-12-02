package PacmanGame;

import java.awt.event.KeyEvent;

import static PacmanGame.Direction.*;

public class InOutPacman {

    private final Pacman pacman;
    private final Main main;

    public InOutPacman(Pacman pacman, Main main){
        this.pacman = pacman;
        this.main = main;
    }


    public Direction giveDirection(int keyCode) {
        Direction direction = null;
        if (keyCode == 38)
            direction = direction.UP;
        else if (keyCode == 40)
            direction = direction.DOWN;
        else if (keyCode == 39)
            direction = direction.RIGHT;
        else if (keyCode == 37)
            direction = direction.LEFT;

        return direction;
    }

    public void receiveKeyEvent(KeyEvent k){
        switch (k.getKeyCode()) {
            case 38 -> pacman.setDirection(UP);
            case 40 -> pacman.setDirection(DOWN);
            case 39 -> pacman.setDirection(RIGHT);
            case 37 -> pacman.setDirection(LEFT);
            case 80 -> main.setPause();
            default -> {
            }
        }
    }
}
