package PacmanGame;

import Moteurs.core.CoreEngine;
import Moteurs.inout.IOEngine;
import PacmanGame.Ghost;
import PacmanGame.Pacman;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class Play {

    private CoreEngine coreEngine;

    private Pacman pacman;

    public enum DIRECTION {UP, RIGHT, LEFT, DOWN}
    public enum GHOSTS {RED, BLUE, ORANGE, PINK}
    private Map<GHOSTS, Ghost> ghosts;


    public void initGame(){
        //coreEngine = new CoreEngine()
        initPlayers();
        initEvents();
    }

    private void initPlayers(){
        pacman = new Pacman(100, 100, coreEngine);
        ghosts = new HashMap<>();
    }

    private void initEvents(){
        coreEngine.addEvent("pacmanGoUp", () -> movePacmanTo(DIRECTION.UP));
        coreEngine.addEvent("pacmanGoDown", () ->movePacmanTo(DIRECTION.DOWN));
        coreEngine.addEvent("pacmanGoLeft", () -> movePacmanTo(DIRECTION.LEFT));
        coreEngine.addEvent("pacmanGoRight", () -> movePacmanTo(DIRECTION.RIGHT));

        coreEngine.getIoEngine().bindEventKeyPressed(KeyEvent.VK_UP, "pacmanGoUp");
        coreEngine.getIoEngine().bindEventKeyPressed(KeyEvent.VK_LEFT, "pacmanGoLeft");
        coreEngine.getIoEngine().bindEventKeyPressed(KeyEvent.VK_RIGHT, "pacmanGoRight");
        coreEngine.getIoEngine().bindEventKeyPressed(KeyEvent.VK_DOWN, "pacmanGoDown");

    }

    private void movePacmanTo(DIRECTION direction){
        pacman.setCurrentDirections(direction); // souligné en rouge je sais pas pq ??
    }

}
