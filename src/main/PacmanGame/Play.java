package PacmanGame;

import Moteurs.core.CoreEngine;
import PacmanGame.AI.Ghost;

import java.util.HashMap;
import java.util.Map;

public class Play {

    private CoreEngine coreEngine;

    private Pacman pacman;
    public enum GHOSTS {RED, BLUE, ORANGE, PINK}
    private Map<GHOSTS, Ghost> ghosts;


    public void initGame(){
        //coreEngine = new CoreEngine()
        initPlayers();
        initEvents();
        initSounds();
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
        coreEngine.addEvent("pacmanGoUp", () -> movePacmanTo(Direction.UP));
        coreEngine.addEvent("pacmanGoDown", () ->movePacmanTo(Direction.DOWN));
        coreEngine.addEvent("pacmanGoLeft", () -> movePacmanTo(Direction.LEFT));
        coreEngine.addEvent("pacmanGoRight", () -> movePacmanTo(Direction.RIGHT));

        // TODO: 01/12/2021
        //coreEngine.getIoEngine().bindEventKeyPressed(KeyEvent.VK_UP, "pacmanGoUp");
        //.getIoEngine().bindEventKeyPressed(KeyEvent.VK_LEFT, "pacmanGoLeft");
       // coreEngine.getIoEngine().bindEventKeyPressed(KeyEvent.VK_RIGHT, "pacmanGoRight");
       // coreEngine.getIoEngine().bindEventKeyPressed(KeyEvent.VK_DOWN, "pacmanGoDown");

    }

    /*
    Fonction qui se charge de charger les sons
     */
    private void initSounds(){
        coreEngine.getSoundEngine().loadSound("pacman_beginning.wav", "PacmanStart");
        coreEngine.getSoundEngine().loadSound("pacman_chomp.wav", "PacmanEatChomp");
        coreEngine.getSoundEngine().loadSound("pacman_death.wav", "PacmanDeath");
        coreEngine.getSoundEngine().loadSound("pacman_eatfruit.wav", "PacmanEatFruit");
        coreEngine.getSoundEngine().loadSound("pacman_eatghost.wav", "PacmanEatGhost");
        coreEngine.getSoundEngine().loadSound("pacman_extrapac.wav", "PacmanExtra");
        coreEngine.getSoundEngine().loadSound("pacman_intermission.wav", "PacmanGeneral");
    }
    /*
    Fonction qui sert à dire à pacman de bouger dans une direction
     */
    private void movePacmanTo(Direction direction){
        pacman.setCurrentDirections(direction); // souligné en rouge je sais pas pq ??
        /*/
        To DO:
        Faire la liaison entre le graphic et la physic quand on bouge
         */
    }

}
