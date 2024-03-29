package Moteurs.graphic;

import org.junit.Test;
import javax.swing.*;
import java.awt.*;
import java.io.File;

import static org.junit.Assert.*;

public class EngineGraphicTest {

    @Test
    public void creationScene() throws InterruptedException {
        GraphicEngine engineGraphic = new GraphicEngine(750, 500, Color.BLACK, "PacmanTest");
        engineGraphic.run();
        Thread.sleep(100);
        JPanel pacman1 = engineGraphic.createEntity(10, 10, new File("src\\main\\Moteurs\\graphic\\pacman.png"));
        engineGraphic.addEntity(pacman1, 100, 100);
    }

    @Test
    public void createAndAddEntityTest(){
        GraphicEngine engineGraphic = new GraphicEngine(50,40, Color.WHITE,"teste");
        JPanel jLabel = engineGraphic.createEntity(10,10,new File("src\\main\\Moteurs\\graphic\\pacman.png"));
        engineGraphic.addEntity(jLabel, 5, 10);
        assertEquals(5, engineGraphic.getAll()[0].getX());
        assertEquals(10, engineGraphic.getAll()[0].getY());

    }

    @Test
    public void mooveEntity(){
        GraphicEngine engineGraphic = new GraphicEngine(50,40, Color.WHITE,"teste");
        JPanel jLabel = engineGraphic.createEntity(10,10,new File("src\\main\\Moteurs\\graphic\\pacman.png"));
        engineGraphic.addEntity(jLabel, 5, 10);
        assertEquals(5, engineGraphic.getAll()[0].getX());
        assertEquals(10, engineGraphic.getAll()[0].getY());
        engineGraphic.setPositionEntity(jLabel, 50,80);
        assertEquals(50, engineGraphic.getAll()[0].getX());
        assertEquals(80, engineGraphic.getAll()[0].getY());
    }


    /**
     * N'a pas vraiment ça place parmis les tests unitaires mais aide grandement au
     * test global de la class
     */
    public static void main(String[] args) throws InterruptedException {
        //Chargement Fond & execution de la fenetre
        GraphicEngine engineGraphic = new GraphicEngine(750, 500, Color.BLACK, "PacmanTest");

        //Pause
        System.out.println("sleep 1");
        Thread.sleep(1000);
        System.out.println("wake up 1");

        //Création et ajout de l'objet
        JPanel pacman1 = engineGraphic.createEntity(10, 10, new File("src\\main\\Moteurs\\graphic\\pacman.png"));
        engineGraphic.addEntity(pacman1, 500, 100);
        engineGraphic.printEntities(); // debug affiche les objets présents et leurs coordonées

        JPanel pacman2 = engineGraphic.createAndAddEntity(100,50,15, 15, new File("src\\main\\Moteurs\\graphic\\pacman.png"));
        //engineGraphic.addEntity(pacman2, 500, 100);

        engineGraphic.run();

        JPanel pacman3 = engineGraphic.createAndAddEntity(100,150,25, 25, new File("src\\main\\Moteurs\\graphic" +
                "\\pacman.png"));
       // engineGraphic.addEntity(pacman3, 100, 100);

        System.out.println("p1:"+pacman1.getWidth()+":"+pacman1.getHeight()+" p2:"+pacman2.getWidth()+":"+pacman2.getHeight()+" p3:"+pacman3.getWidth()+":"+pacman3.getHeight());


        while (true) {
            System.out.println("sleep 3");
            Thread.sleep(1000);
            System.out.println("wake up 3");

            //Test de bouger l'objet diretement
            //pacman1.setBounds(100,10, pacman1.getWidth(), pacman1.getHeight());
            engineGraphic.setPositionEntity(pacman1, 100, 10);
            engineGraphic.setPositionEntity(pacman2, 80, 20);
            engineGraphic.setPositionEntity(pacman3, 380, 320);

            System.out.println("sleep 4");
            Thread.sleep(1000);
            System.out.println("wake up 4");

            //Test de bouger l'objet diretement
            //pacman1.setBounds(100,100, pacman1.getWidth(), pacman1.getHeight());
            engineGraphic.setPositionEntity(pacman1, 700, 500);
            engineGraphic.setPositionEntity(pacman2, 20, 20);
            engineGraphic.setPositionEntity(pacman3, 300, 320);

        }

    }


}



