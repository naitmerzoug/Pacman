package PacmanGame;

import Moteurs.core.CoreEngine;

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
    /*
    Fonction qui instancie les différents "joueurs" du jeu: Pacman et les fantômes
     */
    private void initPlayers(){
        pacman = new Pacman(100, 100, coreEngine);
        ghosts = new HashMap<>();
    }
    /*
    Fonction qui crée et lie les événements d'entrée/sorties au clavier
     */
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
    /*
    Fonction qui sert à dire à pacman de bouger dans une direction
     */
    private void movePacmanTo(DIRECTION direction){
        pacman.setCurrentDirections(direction); // souligné en rouge je sais pas pq ??
        /*/
        To DO:
        Faire la liaison entre le graphic et la physic quand on bouge
         */
    }

}
