package PacmanGame;

import PacmanGame.Entities.Pacman;

import java.awt.event.KeyEvent;

import static Moteurs.physic.DIRECTION.*;

/**
 * Moteur entrée/sortie spécifique Pacman
 */
public class InOutPacman {

    /**
     * Personnage Pacman
     */
    private final Pacman pacman;
    /**
     * Moteur spécifique Pacman
     */
    private final PacmanGame main;

    /**
     * Constructeur du moteur IO spécifique Pacman
     * @param pacman Personnage Pacman
     * @param main Moteur spécifique
     */
    public InOutPacman(Pacman pacman, PacmanGame main){
        this.pacman = pacman;
        this.main = main;
    }

    /**
     * Gestion du jeu en fonction des touches appuyés
     * @param k Code la touche appuyé
     */
    public void receiveKeyEvent(KeyEvent k){
        switch (k.getKeyCode()) {
            case 38 -> pacman.getCoreEntity().getPhysicEntity().setDirection(UP);
            case 40 -> pacman.getCoreEntity().getPhysicEntity().setDirection(DOWN);
            case 39 -> pacman.getCoreEntity().getPhysicEntity().setDirection(RIGHT);
            case 37 -> pacman.getCoreEntity().getPhysicEntity().setDirection(LEFT);
            default -> {
            }
        }
    }

}
