package PacmanGame;

import Moteurs.Game;
import Moteurs.core.CoreEngine;
import PacmanGame.AI.Ghost;
import PacmanGame.Entities.Pacman;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class PacmanGame implements Game {

    private CoreEngine coreEngine;
    private InOutPacman inOutPacman;
    private Pacman pacman;

    double physicHeight = 100;
    double physicWidth = 80;
    int graphicHeight = (int) physicHeight * 10 ;
    int graphicWidth  = (int)  physicWidth * 10 ;

    public PacmanGame(){
        coreEngine = new CoreEngine(physicHeight, physicWidth, graphicHeight, graphicWidth);
        coreEngine.setGame(this);
        initPlayers();
        initEvents();
        initSounds();
        initMap();
    }

    private void initMap() {

    }

    @Override
    public void getKeyEvent(KeyEvent keyEvent) {
        inOutPacman.receiveKeyEvent(keyEvent);
    }

    public void run() {
        coreEngine.run();
        coreEngine.getSoundEngine().playSound("PacmanStart");
        while(pacman.isAlive()){
            //Jeu
            //coreEngine.moveAll();
        }
    }

    public void initiliszeEntities(){
       // coreEngine.createAndAddEntity(Type type, double x, double y, double length, double width, int speed, File file)
    }

    public void setPause() {
        coreEngine.setPause( ! coreEngine.getPause());
    }

    public enum GHOSTS {RED, BLUE, ORANGE, PINK}
    private Map<GHOSTS, Ghost> ghosts;

    /*
    Fonction qui instancie les différents "joueurs" du jeu: Pacman et les fantômes
     */
    private void initPlayers(){
        this.pacman = new Pacman(100, 100, coreEngine);
        this.inOutPacman = new InOutPacman(this.pacman,this);
        this.ghosts = new HashMap<>();
    }

    /*
    Fonction qui crée et lie les événements d'entrée/sorties au clavier
     */
    private void initEvents(){
        coreEngine.addEvent("pacmanGoUp", () -> movePacmanTo(Direction.UP));
        coreEngine.addEvent("pacmanGoDown", () ->movePacmanTo(Direction.DOWN));
        coreEngine.addEvent("pacmanGoLeft", () -> movePacmanTo(Direction.LEFT));
        coreEngine.addEvent("pacmanGoRight", () -> movePacmanTo(Direction.RIGHT));


        //coreEngine.getIOEngine().bindEventKeyPressed(KeyEvent.VK_UP, "pacmanGoUp");
        //.getIoEngine().bindEventKeyPressed(KeyEvent.VK_LEFT, "pacmanGoLeft");
        // coreEngine.getIoEngine().bindEventKeyPressed(KeyEvent.VK_RIGHT, "pacmanGoRight");
        // coreEngine.getIoEngine().bindEventKeyPressed(KeyEvent.VK_DOWN, "pacmanGoDown");

    }

    /*
    Fonction qui se charge de charger les sons
     */
    private void initSounds(){
        coreEngine.getSoundEngine().loadSound("src/assets/sound/pacman_beginning.wav", "PacmanStart");
        coreEngine.getSoundEngine().loadSound("src/assets/sound/pacman_chomp.wav", "PacmanEatChomp");
        coreEngine.getSoundEngine().loadSound("src/assets/sound/pacman_death.wav", "PacmanDeath");
        coreEngine.getSoundEngine().loadSound("src/assets/sound/pacman_eatfruit.wav", "PacmanEatFruit");
        coreEngine.getSoundEngine().loadSound("src/assets/sound/pacman_eatghost.wav", "PacmanEatGhost");
        coreEngine.getSoundEngine().loadSound("src/assets/sound/pacman_extrapac.wav", "PacmanExtra");
        coreEngine.getSoundEngine().loadSound("src/assets/sound/pacman_intermission.wav", "PacmanGeneral");
    }


    /*
    Fonction qui sert à dire à pacman de bouger dans une direction
     */
    private void movePacmanTo(Direction direction){
        pacman.setDirection(direction);
    }




}
