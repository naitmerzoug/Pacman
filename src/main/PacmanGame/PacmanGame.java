package PacmanGame;

import Moteurs.Game;
import Moteurs.core.CoreEngine;

import PacmanGame.AI.*;
import PacmanGame.Entities.Coin;
import PacmanGame.Entities.Pacman;
import PacmanGame.Entities.Wall;

import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Moteur spécifique Pacman
 */
public class PacmanGame implements Game {

    /**
     * Moteur noyau
     */
    private final CoreEngine coreEngine;

    /**
     * Moteur spécifique entrée/sortie Pacman
     */
    private InOutPacman inOutPacman;

    /**
     * Personnage Pacman
     */
    private Pacman pacman;

    /**
     * Liste de pièces. Quand elle est vide, la partie est gagnée.
     */
    private ArrayList<Coin> coins;


    /**
     * Constructeur du jeu Pacman
     * @param physicHeight Hauteur de l'espace physique
     * @param physicWidth Largeur de l'espace physique
     */
    public PacmanGame(double physicHeight, double physicWidth) {

        this.coreEngine = new CoreEngine("Pacman Game", physicHeight, physicWidth);
        this.coreEngine.setGame(this);
        this.coins = new ArrayList<>();
        initPlayers();
        initSounds();
        initMap();
        initCoins();
    }

    /**
     * Récupère la touche appuyée
     */
    @Override
    public void getKeyEvent(KeyEvent keyEvent) {
        inOutPacman.receiveKeyEvent(keyEvent);
    }


    /**
     * Permet le démarrage du jeu Pacman
     */
    public void run() throws InterruptedException {
        coreEngine.run();

        Thread.sleep(1000);

        while(pacman.isAlive()){
            //Jeu
            //coreEngine.getSoundEngine().loopSound("PacmanStart");
            coreEngine.moveEntity(pacman.getCoreEntity(), pacman.getCoreEntity().getPhysicEntity().getDirection());
            Thread.sleep(30);
        }

    }

    /**
     * Initialise les personnages du jeu
     */
    private void initPlayers(){
        this.pacman = new Pacman(2, -45, coreEngine); // id 1
        this.inOutPacman = new InOutPacman(pacman,this);
        BlueGhost blueGhost = new BlueGhost(45, -45, coreEngine); // id 2
        OrangeGhost orangeGhost = new OrangeGhost(50,-50,coreEngine);
        PinkGhost pinkGhost = new PinkGhost(40,-50,coreEngine);
        RedGhost redGhost = new RedGhost(40,-42,coreEngine);
    }

    /**
     * Charge les sons
     */
    private void initSounds(){
        coreEngine.getSoundEngine().loadSound("/PacmanGame/Sounds/pacman_beginning.wav", "PacmanStart");
        coreEngine.getSoundEngine().loadSound("/PacmanGame/Sounds/pacman_chomp.wav", "PacmanEatChomp");
        coreEngine.getSoundEngine().loadSound("/PacmanGame/Sounds/pacman_death.wav", "PacmanDeath");
        coreEngine.getSoundEngine().loadSound("/PacmanGame/Sounds/pacman_eatfruit.wav", "PacmanEatFruit");
        coreEngine.getSoundEngine().loadSound("/PacmanGame/Sounds/pacman_eatghost.wav", "PacmanEatGhost");
        coreEngine.getSoundEngine().loadSound("/PacmanGame/Sounds/pacman_extrapac.wav", "PacmanExtra");
        coreEngine.getSoundEngine().loadSound("/PacmanGame/Sounds/pacman_intermission.wav", "PacmanGeneral");

    }

    private void initCoins(){
        for (int i = 2; i < 28; i=i+2) {
            Coin coin = new Coin(1.5, -i, coreEngine);
            coins.add(coin);
        }
        for (int i = 5; i < 28; i=i+3){
            Coin coin = new Coin(i, -17, coreEngine);
            coins.add(coin);
        }

        for (int i = 28; i < 60; i=i+3){
            Coin coin = new Coin(i, -35, coreEngine);
            coins.add(coin);
        }

        for (int i = 28; i < 60; i=i+3){
            Coin coin = new Coin(i, -57, coreEngine);
            coins.add(coin);
        }

        for (int i = 28; i < 60; i=i+3){
            Coin coin = new Coin(68, -i, coreEngine);
            coins.add(coin);
        }

        for (int i = 67; i < 75; i=i+3){
            Coin coin = new Coin(2, -i, coreEngine);
            coins.add(coin);
        }

        for (int i = 67; i < 75; i=i+3){
            Coin coin = new Coin(85, -i, coreEngine);
            coins.add(coin);
        }

        for (int i = 28; i < 75; i=i+3){
            Coin coin = new Coin(i, -92, coreEngine);
            coins.add(coin);
        }
    }

    /**
     * Initialise la map (murs)
     */
    private void initMap() {

        /*
         * Partie haute gauche
         */
        Wall wall1 = new Wall(0,0,1,90, coreEngine); // id 6
        Wall wall2 = new Wall(0, 0, 30, 1, coreEngine);
        Wall wall3 = new Wall(0, -30, 1, 16, coreEngine);
        Wall wall4 = new Wall(16, -30, 10, 1, coreEngine);
        Wall wall5 = new Wall(0, -40, 1, 17, coreEngine);

        // Moyen rectangle
        Wall wall6 = new Wall(6, -6.5, 1, 10, coreEngine); // Mur du haut
        Wall wall7 = new Wall(16, -6.5, 8, 1, coreEngine); // Mur à droite
        Wall wall8 = new Wall(6, -6.5, 8, 1, coreEngine); // Mur à gauche
        Wall wall9 = new Wall(6, -14.5, 1, 11, coreEngine); // Mur en bas

        // Petit rectangle
        Wall wall10 = new Wall(6, -20, 1, 10, coreEngine); // Mur du haut
        Wall wall11 = new Wall(16, -20, 4, 1, coreEngine); // Mur à droite
        Wall wall12 = new Wall(6, -20, 4, 1, coreEngine); // Mur à gauche
        Wall wall13 = new Wall(6, -24, 1, 11, coreEngine); // Mur en bas

        // Grand rectangle
        Wall wall14 = new Wall(22, -6.5, 1, 15, coreEngine);
        Wall wall15 = new Wall(37, -6.5, 8, 1, coreEngine);
        Wall wall16 = new Wall(22, -6.5, 8, 1, coreEngine);
        Wall wall17 = new Wall(22, -14.5, 1, 16, coreEngine);

        // Pylone | Séparateur droite / gauche
        Wall wall18 = new Wall(43, 0, 15.5, 2, coreEngine);

        // T vertical
        Wall wall19 = new Wall(22, -20, 1, 3, coreEngine);
        Wall wall20 = new Wall(22, -20, 21, 1, coreEngine);
        Wall wall21 = new Wall(25, -20, 8, 1, coreEngine);
        Wall wall22 = new Wall(25, -28, 1, 12, coreEngine);
        Wall wall23 = new Wall(36, -28, 4, 1, coreEngine);
        Wall wall24 = new Wall(25, -32, 1, 12, coreEngine);
        Wall wall25 = new Wall(25, -32, 9, 1, coreEngine);
        Wall wall26 = new Wall(22, -40, 1, 4, coreEngine);

        // T central horizontal
        Wall wall27 = new Wall(32, -20, 1, 23, coreEngine);
        Wall wall28 = new Wall(32, -20, 2, 1, coreEngine);
        Wall wall29 = new Wall(32, -22, 1, 10, coreEngine);
        Wall wall30 = new Wall(42, -22, 10, 1, coreEngine);
        Wall wall31 = new Wall(42, -32, 1, 4, coreEngine);
        Wall wall32 = new Wall(45, -22, 10, 1, coreEngine);
        Wall wall33 = new Wall(45, -22, 1, 10, coreEngine);
        Wall wall34 = new Wall(54, -20, 2, 1, coreEngine);

        // Partie haute droite


        Wall wall1_sym = new Wall(89, 0, 30, 1, coreEngine);
        Wall wall3_sym = new Wall(73, -30, 1, 17, coreEngine);
        Wall wall4_sym = new Wall(73, -30, 10, 1, coreEngine);
        Wall wall5_sym = new Wall(73, -40, 1, 17, coreEngine);

        // Moyen rectangle
        Wall wall6_sym = new Wall(73, -6.5, 1, 10, coreEngine);
        Wall wall7_sym = new Wall(83, -6.5, 8, 1, coreEngine);
        Wall wall8_sym = new Wall(73, -6.5, 8, 1, coreEngine);
        Wall wall9_sym = new Wall(73, -14.5, 1, 11, coreEngine);

        // Petit rectangle
        Wall wall10_sym = new Wall(73, -20, 1, 10, coreEngine);
        Wall wall11_sym = new Wall(83, -20, 4, 1, coreEngine);
        Wall wall12_sym = new Wall(73, -20, 4, 1, coreEngine);
        Wall wall13_sym = new Wall(73, -24, 1, 11, coreEngine);

        // Grand rectangle
        Wall wall14_sym = new Wall(51, -6.5, 1, 15, coreEngine);
        Wall wall15_sym = new Wall(66, -6.5, 8, 1, coreEngine);
        Wall wall16_sym = new Wall(51, -6.5, 8, 1, coreEngine);
        Wall wall17_sym = new Wall(51, -14.5, 1, 16, coreEngine);

        // T vertical
        Wall wall19_sym = new Wall(63, -20, 1, 3, coreEngine);
        Wall wall20_sym = new Wall(66, -20, 21, 1, coreEngine);
        Wall wall21_sym = new Wall(63, -20, 8, 1, coreEngine);
        Wall wall22_sym = new Wall(52, -28, 1, 12, coreEngine);
        Wall wall23_sym = new Wall(52, -28, 4, 1, coreEngine);
        Wall wall24_sym = new Wall(52, -32, 1, 12, coreEngine);
        Wall wall25_sym = new Wall(63, -32, 9, 1, coreEngine);
        Wall wall26_sym = new Wall(63, -40, 1, 4, coreEngine);

        // Partie bas gauche

        Wall wall35 = new Wall(0,-95,1,90, coreEngine);
        Wall wall36 = new Wall(0, -81, 14, 1, coreEngine);

        // Petit truc qui sort
        Wall wall37 = new Wall(0, -81, 1, 6, coreEngine);
        Wall wall38 = new Wall(6, -78, 4, 1, coreEngine);
        Wall wall39 = new Wall(0, -78, 1, 6, coreEngine);

        Wall wall40 = new Wall(0, -64, 14, 1, coreEngine);
        Wall wall41 = new Wall(0, -64, 1, 17, coreEngine);
        //Wall wall42 = new Wall(16, -54, 10, 1, coreEngine); // id 71
        Wall wall43 = new Wall(0, -54, 1, 16, coreEngine);

        // T horizontal décallé
        Wall wall44 = new Wall(6, -89, 1, 30, coreEngine);
        Wall wall45 = new Wall(6, -86, 3, 1, coreEngine);
        Wall wall46 = new Wall(6, -86, 1, 15, coreEngine);
        Wall wall47 = new Wall(21, -78, 9, 1, coreEngine);
        Wall wall48 = new Wall(22, -78, 1, 3, coreEngine);
        Wall wall49 = new Wall(25, -78, 9, 1, coreEngine);
        Wall wall50 = new Wall(26, -86, 1, 9, coreEngine);
        Wall wall51 = new Wall(35, -86, 4, 1, coreEngine);

        // Semi T vers la gauche
        Wall wall52 = new Wall(12, -81, 1, 5, coreEngine); // mur du bas
        Wall wall53 = new Wall(12, -71, 11, 1, coreEngine);
        Wall wall54 = new Wall(16, -70, 11, 1, coreEngine);
        Wall wall55 = new Wall(7, -71, 1, 5, coreEngine);
        Wall wall56 = new Wall(7, -69, 2, 1, coreEngine);
        Wall wall57 = new Wall(7, -69, 1, 10, coreEngine);

        // Petit rectangle
        Wall wall58 = new Wall(21, -69, 1, 15, coreEngine);
        Wall wall59 = new Wall(21, -69, 3, 1, coreEngine);
        Wall wall60 = new Wall(21, -72, 1, 15, coreEngine);
        Wall wall61 = new Wall(35, -69, 3, 1, coreEngine);

        // T central Bas
        Wall wall62 = new Wall(32, -78, 1, 23, coreEngine);
        Wall wall63 = new Wall(32, -78, 2, 1, coreEngine);
        Wall wall64 = new Wall(32, -80, 1, 10, coreEngine);
        Wall wall65 = new Wall(42, -80, 9, 1, coreEngine);
        Wall wall66 = new Wall(42, -89, 1, 4, coreEngine);
        Wall wall67 = new Wall(45, -80, 9, 1, coreEngine);
        Wall wall68 = new Wall(45, -80, 1, 10, coreEngine);
        Wall wall69 = new Wall(54, -78, 2, 1, coreEngine);

        // T central mid
        Wall wall70 = new Wall(32, -61, 1, 23, coreEngine);
        Wall wall71 = new Wall(32, -61, 2, 1, coreEngine);
        Wall wall72 = new Wall(32, -63, 1, 10, coreEngine);
        Wall wall73 = new Wall(42, -63, 9, 1, coreEngine);
        Wall wall74 = new Wall(42, -72, 1, 4, coreEngine);
        Wall wall75 = new Wall(45, -63, 9, 1, coreEngine);
        Wall wall76 = new Wall(45, -63, 1, 10, coreEngine);
        Wall wall77 = new Wall(54, -61, 2, 1, coreEngine);

        // Petit rectangle horizontal
        Wall wall78 = new Wall(21, -54, 11, 1, coreEngine);
        Wall wall79 = new Wall(21, -54, 1, 4, coreEngine);
        Wall wall80 = new Wall(25, -54, 11, 1, coreEngine);
        Wall wall81 = new Wall(21, -64, 1, 5, coreEngine);

        // Partie bas droite


        Wall wall36_sym = new Wall(89, -81, 14, 1, coreEngine);

        // Petit truc qui sort sym
        Wall wall37_sym = new Wall(83, -81, 1, 6, coreEngine);
        Wall wall38_sym = new Wall(83, -78, 4, 1, coreEngine);
        Wall wall39_sym = new Wall(83, -78, 1, 7, coreEngine);

        Wall wall40_sym = new Wall(89, -64, 14, 1, coreEngine);
        Wall wall41_sym = new Wall(73, -64, 1, 17, coreEngine);
        Wall wall42_sym = new Wall(73, -54, 10, 1, coreEngine);
        Wall wall43_sym = new Wall(73, -54, 1, 17, coreEngine);

        // T horizontal décallé
        Wall wall44_sym = new Wall(52, -89, 1, 31, coreEngine);
        Wall wall45_sym = new Wall(52, -86, 3, 1, coreEngine);
        Wall wall46_sym = new Wall(52, -86, 1, 9, coreEngine);
        Wall wall47_sym = new Wall(61, -78, 9, 1, coreEngine);
        Wall wall48_sym = new Wall(62, -78, 1, 3, coreEngine);
        Wall wall49_sym = new Wall(65, -78, 9, 1, coreEngine);
        Wall wall50_sym = new Wall(65, -86, 1, 18, coreEngine);
        Wall wall51_sym = new Wall(83, -86, 4, 1, coreEngine);

        // Semi T vers la gauche
        Wall wall52_sym = new Wall(73, -81, 1, 5, coreEngine);
        Wall wall53_sym = new Wall(73, -70, 11, 1, coreEngine);
        Wall wall54_sym = new Wall(77, -71, 11, 1, coreEngine);
        Wall wall55_sym = new Wall(77, -71, 1, 6, coreEngine);
        Wall wall56_sym = new Wall(82, -69, 2, 1, coreEngine);
        Wall wall57_sym = new Wall(73, -69, 1, 10, coreEngine);

        // Petit rectangle
        Wall wall58_sym = new Wall(52, -69, 1, 14, coreEngine);
        Wall wall59_sym = new Wall(52, -69, 3, 1, coreEngine);
        Wall wall60_sym = new Wall(52, -72, 1, 14, coreEngine);
        Wall wall61_sym = new Wall(65, -69, 3, 1, coreEngine);

        // Petit rectangle horizontal
        Wall wall78_sym = new Wall(62, -54, 11, 1, coreEngine);
        Wall wall79_sym = new Wall(62, -54, 1, 4, coreEngine);
        Wall wall80_sym = new Wall(66, -54, 11, 1, coreEngine);
        Wall wall81_sym = new Wall(62, -64, 1, 5, coreEngine);

        // Cage à fantôme
        Wall wall82 = new Wall(32, -55, 1, 23, coreEngine);
        Wall wall83 = new Wall(32, -38, 17, 1, coreEngine); // id 142
        Wall wall84 = new Wall(32, -38, 1, 8, coreEngine);
        Wall wall85 = new Wall(48, -38, 1, 7, coreEngine);
        Wall wall86 = new Wall(54, -38, 17, 1, coreEngine);
    }


}
