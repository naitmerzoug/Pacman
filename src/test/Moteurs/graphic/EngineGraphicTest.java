package Moteurs.graphic;

import Moteurs.graphic.GraphicEngine;
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
        JLabel pacman1 = engineGraphic.createEntity(10, 10, new File("src\\main\\Moteurs\\graphic\\pacman.png"));
        engineGraphic.addEntity(pacman1, 100, 100);
    }

    @Test
    public void createAndAddEntityTest(){
        GraphicEngine engineGraphic = new GraphicEngine(50,40, Color.WHITE,"teste");
        JLabel jLabel = engineGraphic.createEntity(10,10,new File("src\\main\\Moteurs\\graphic\\pacman.png"));
        engineGraphic.addEntity(jLabel, 5, 10);
        assertEquals(5, engineGraphic.getAll()[0].getX());
        assertEquals(10, engineGraphic.getAll()[0].getY());

    }

    @Test
    public void mooveEntity(){
        GraphicEngine engineGraphic = new GraphicEngine(50,40, Color.WHITE,"teste");
        JLabel jLabel = engineGraphic.createEntity(10,10,new File("src\\main\\Moteurs\\graphic\\pacman.png"));
        engineGraphic.addEntity(jLabel, 5, 10);
        assertEquals(5, engineGraphic.getAll()[0].getX());
        assertEquals(10, engineGraphic.getAll()[0].getY());
        engineGraphic.mooveEntity(jLabel, 50,80);
        assertEquals(50, engineGraphic.getAll()[0].getX());
        assertEquals(80, engineGraphic.getAll()[0].getY());
    }


    /**
     * N'a pas vraiment ça place parmis les tests unitaires mais aide grandement au
     * test global de la class
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        //Chargement Fond & execution de la fenetre
        GraphicEngine engineGraphic = new GraphicEngine(750, 500, Color.BLACK, "PacmanTest");

        //Pause
        System.out.println("sleep 1");
        Thread.sleep(1000);
        System.out.println("wake up 1");

        //Création et ajout de l'objet
        JLabel pacman1 = engineGraphic.createEntity(10, 10, new File("src\\main\\Moteurs\\graphic\\pacman.png"));
        engineGraphic.addEntity(pacman1, 500, 100);
        engineGraphic.printEntities(); // debug affiche les objets présents et leurs coordonées

        JLabel pacman2 = engineGraphic.createEntity(15, 15, new File("src\\main\\Moteurs\\graphic\\pacman.png"));
        engineGraphic.addEntity(pacman2, 500, 100);

        engineGraphic.run();

        JLabel pacman3 = engineGraphic.createEntity(25, 25, new File("src\\main\\Moteurs\\graphic" +
                "\\pacman.png"));
        engineGraphic.addEntity(pacman3, 100, 100);


        while (true) {
            System.out.println("sleep 3");
            Thread.sleep(1000);
            System.out.println("wake up 3");

            //Test de bouger l'objet diretement
            //pacman1.setBounds(100,10, pacman1.getWidth(), pacman1.getHeight());
            engineGraphic.mooveEntity(pacman1, 100, 10);
            engineGraphic.mooveEntity(pacman2, 80, 20);
            engineGraphic.mooveEntity(pacman3, 380, 320);

            System.out.println("sleep 4");
            Thread.sleep(1000);
            System.out.println("wake up 4");

            //Test de bouger l'objet diretement
            //pacman1.setBounds(100,100, pacman1.getWidth(), pacman1.getHeight());
            engineGraphic.mooveEntity(pacman1, 700, 500);
            engineGraphic.mooveEntity(pacman2, 20, 20);
            engineGraphic.mooveEntity(pacman3, 300, 320);

        }

    }



}



