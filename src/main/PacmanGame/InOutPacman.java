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

    private enum Status{DOWN, UP, LEFT, RIGHT, PAUSE}

    public Status giveStatus(int keyCode) {
        Status status = null;
        if (keyCode == 38)
            status = Status.UP;
        else if (keyCode == 40)
            status = Status.DOWN;
        else if (keyCode == 39)
            status = Status.RIGHT;
        else if (keyCode == 37)
            status = Status.LEFT;
        else if (keyCode == 80)
            status = Status.PAUSE;


        return status;
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
