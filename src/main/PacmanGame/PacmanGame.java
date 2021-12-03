package PacmanGame;

import Moteurs.Game;
import Moteurs.core.CoreEngine;
import Moteurs.core.CoreEntity;
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

    double physicHeight = 85.5;
    double physicWidth = 73.5;
    private Timestamp endBonusTime;

    public PacmanGame(){
        coreEngine = new CoreEngine("Pacman Game", physicHeight, physicWidth);
        coreEngine.setGame(this);
        this.inOutPacman = new InOutPacman(pacman,this);
        initPlayers();
        //initEvents();
        initSounds();
        initMap();
        this.endBonusTime = Timestamp.from(Instant.now());
    }

    private void initMap() {
      //Wall(int x, int y,int length, int width, CoreEngine coreEngine)
        // taille map = 57 x 5 pixel = 285 sur 49 x 5 = 245
        Wall wall1 = new Wall(0,0,1.5,73.5, coreEngine);
        Wall wall2 = new Wall(0,-80.5,1.5,73.5,coreEngine);
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


        coreEngine.movePacman(pacman.getCoreEntity(), pacman.getCoreEntity().getEntityPhysic().getDirection() ,1);
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
            
            coreEngine.movePacman(pacman.getCoreEntity(), pacman.getCoreEntity().getEntityPhysic().getDirection() ,1);
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
        pacman = new Pacman(10, -10, coreEngine);
        this.inOutPacman = new InOutPacman(this.pacman,this);
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
    private void movePacmanTo(Direction direction){
        pacman.setDirection(direction);
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
