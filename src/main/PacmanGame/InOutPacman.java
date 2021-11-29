package PacmanGame;

public class InOutPacman {

    public InOutPacman() {

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
}
