package PacmanGame;

import Moteurs.Game;
import Moteurs.core.CoreEngine;
import Moteurs.core.CoreEntity;
import Moteurs.physic.DIRECTION;
import PacmanGame.AI.Ghost;
import PacmanGame.Entities.Pacman;
import PacmanGame.Entities.Wall;

import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

public class PacmanGame implements Game {

    private CoreEngine coreEngine;
    private InOutPacman inOutPacman;
    private Pacman pacman;
    private ArrayList<Ghost> ghosts;

    double physicHeight = 100;
    double physicWidth = 90;
    private Timestamp endBonusTime;

    public PacmanGame(){
        this.coreEngine = new CoreEngine("Pacman Game", physicHeight, physicWidth);
        this.coreEngine.setGame(this);
        this.pacman = new Pacman(1, -8, coreEngine);
        this.inOutPacman = new InOutPacman(pacman,this);
        //initPlayers();
        //initEvents();
        initSounds();
        initMap();
        this.endBonusTime = Timestamp.from(Instant.now());
    }

    private void initMap() {
      //Wall(int x, int y,int length, int width, CoreEngine coreEngine)
        // taille map = 57 x 5 pixel = 285 sur 49 x 5 = 245

        /**
         * Partie haute gauche
         */
        Wall wall1 = new Wall(0,0,1,90, coreEngine);
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

        /**
         * Partie haute droite
         */

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

        /**
         * Partie bas gauche
         */

        Wall wall35 = new Wall(0,-95,1,90, coreEngine);
        Wall wall36 = new Wall(0, -81, 14, 1, coreEngine);

        // Petit truc qui sort
        Wall wall37 = new Wall(0, -81, 1, 6, coreEngine);
        Wall wall38 = new Wall(6, -78, 4, 1, coreEngine);
        Wall wall39 = new Wall(0, -78, 1, 6, coreEngine);

        Wall wall40 = new Wall(0, -64, 14, 1, coreEngine);
        Wall wall41 = new Wall(0, -64, 1, 17, coreEngine);
        Wall wall42 = new Wall(16, -54, 10, 1, coreEngine);
        Wall wall43 = new Wall(0, -54, 1, 16, coreEngine);

        // T horizontal décallé
        Wall wall44 = new Wall(6, -89, 1, 30, coreEngine);
        Wall wall45 = new Wall(6, -86, 3, 1, coreEngine);
        Wall wall46 = new Wall(6, -86, 1, 18, coreEngine);
        Wall wall47 = new Wall(24, -78, 9, 1, coreEngine);
        Wall wall48 = new Wall(24, -78, 1, 4, coreEngine);
        Wall wall49 = new Wall(28, -78, 9, 1, coreEngine);
        Wall wall50 = new Wall(28, -86, 1, 8, coreEngine);
        Wall wall51 = new Wall(36, -86, 4, 1, coreEngine);

        // Semi T vers la gauche
        Wall wall52 = new Wall(14, -81, 1, 5, coreEngine); // mur du bas
        Wall wall53 = new Wall(14, -71, 11, 1, coreEngine);
        Wall wall54 = new Wall(18, -70, 11, 1, coreEngine);
        Wall wall55 = new Wall(9, -71, 1, 5, coreEngine);
        Wall wall56 = new Wall(9, -69, 2, 1, coreEngine);
        Wall wall57 = new Wall(9, -69, 1, 10, coreEngine);

        // Petit rectangle
        Wall wall58 = new Wall(24, -69, 1, 8, coreEngine);

        /**
         * Partie bas droite
         */
        /*
        Wall wall2_sym = new Wall(89, -65, 30, 1, coreEngine);

         */

    }

    @Override
    public void getKeyEvent(KeyEvent keyEvent) {
        inOutPacman.receiveKeyEvent(keyEvent);
    }

    public void run() throws InterruptedException {
        coreEngine.run();
        //coreEngine.getSoundEngine().playSound("PacmanStart");
        System.out.println("sleep");
        Thread.sleep(1000);
        System.out.println("up");

        while(pacman.isAlive()){
            //Jeu
            coreEngine.moveAll();


        coreEngine.movePacman(pacman.getCoreEntity(), pacman.getCoreEntity().getPhysicEntity().getDirection() ,1);
        Thread.sleep(30);
        }
    }

    public void runTestMoovePacman() throws InterruptedException {
        coreEngine.run();
        //coreEngine.getSoundEngine().playSound("PacmanStart");
        System.out.println("sleep");
        Thread.sleep(1000);
        System.out.println("up");

        while(pacman.isAlive()){
            //Jeu
            coreEngine.moveAll();


            coreEngine.movePacman(pacman.getCoreEntity(), pacman.getCoreEntity().getPhysicEntity().getDirection() ,1);
            Thread.sleep(30);
        }
    }

    public void initiliszeEntities(){
       // coreEngine.createAndAddEntity(Type type, double x, double y, double length, double width, int speed, File file)
    }

    public void setPause() {
        coreEngine.setPause( ! coreEngine.getPause());
    }

    public void initGame(){
        //coreEngine = new CoreEngine()
        initPlayers();
        initSounds();
    }

    /*
    Fonction qui instancie les différents "joueurs" du jeu: Pacman et les fantômes
     */
    private void initPlayers(){
    }

    /*
    Fonction qui crée et lie les événements d'entrée/sorties au clavier
     */
    /*
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

     */

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
    private void movePacmanTo(DIRECTION direction){
        pacman.getCoreEntity().getPhysicEntity().setDirection(direction);
    }

    // TODO: 03/12/2021
    @Override
    public void sendCollisionList(CoreEntity coreEntity, ArrayList<CoreEntity> coreEntities) {
        //test les collisions pour chaque entities
        for(CoreEntity entity : coreEntities) {
            if (CollisionManage.isWallCollision(coreEntities,entity)){
                return;
            }
            if (CollisionManage.isGhostCollision(coreEntities,entity)){
                if(isStartBonus())
                    pacman.eatGhost(getGhots(entity));
                else
                    pacman.die();
            }
            if (CollisionManage.isCoinCollision(coreEntities,entity)){
                pacman.eatCoin(entity);
            }
            if (CollisionManage.isBonusCollision(coreEntities,entity)){
                pacman.eatBonus(entity);
                starBonusTime(Timestamp.from(Instant.now()));
            }

        }
    }

    private Ghost getGhots(CoreEntity entity) {
        for(Ghost ghost : ghosts){
            if(ghost.getId() == entity.getId())
                return ghost;
        }
        return null;
    }

    private void starBonusTime(Timestamp from) {
        this.endBonusTime = from  /* 10sec*/;
    }

    // TODO: 03/12/2021
    private boolean isStartBonus() {
        return false;
    }


}
