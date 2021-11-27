package Moteurs.graphicm;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class EngineGraphicTest {

    @Test
    public void creationScene() throws InterruptedException {
        EngineGraphic engineGraphic = new EngineGraphic(750, 500, Color.BLACK, "PacmanTest");
        engineGraphic.run();
        Thread.currentThread().sleep(100);
        JLabel pacman1 = engineGraphic.createEntity(10,10,new File("C:\\Users\\flo-t\\IdeaProjects\\Pacman\\src\\main\\Moteurs\\graphicm\\pacman.png"));
        engineGraphic.addEntity(pacman1,100,100);
    }

    public static void main(String[] args) throws InterruptedException {
        //Chargement Fond & execution de la fenetre
        EngineGraphic engineGraphic = new EngineGraphic(750, 500, Color.BLACK, "PacmanTest");

        //Pause
        System.out.println("sleep 1");
        Thread.sleep(1000);
        System.out.println("wake up 1");

        //Création et ajout de l'objet
        JLabel pacman1 = engineGraphic.createEntity(10,10,new File("C:\\Users\\flo-t\\IdeaProjects\\Pacman\\src\\main\\Moteurs\\graphicm\\pacman.png"));
        engineGraphic.addEntity(pacman1,500,100);
        engineGraphic.printEntities(); // debug affiche les objets présents et leurs coordonées
        engineGraphic.run();
//        //Pause
//        System.out.println("sleep 2");
//        Thread.currentThread().sleep(100);
//        System.out.println("wake up 2");

//        //On essaye de manipuler les composants directement en les appelant depuis frame
//        for(Component components : engineGraphic.getAll()) {
//            System.out.println(components.getX() + " " + components.getY());// debug affiche coordonées
//
//            //On essaye de faire bouger l'objet
//            System.out.println("pre-moove");
//            engineGraphic.mooveEntity(components, 100, 100);
//            System.out.println("next");
//
//            System.out.println(components.getX() + " " + components.getY());// debug affiche coordonées
//        }

        //Pause
        for(int i =0; i<10; i++){
            System.out.println("sleep 3");
            Thread.sleep(1000);
            System.out.println("wake up 3");

            //Test de bouger l'objet diretement
            pacman1.setBounds(100,10, pacman1.getWidth(), pacman1.getHeight());

            System.out.println("sleep 4");
            Thread.sleep(1000);
            System.out.println("wake up 4");

            //Test de bouger l'objet diretement
            pacman1.setBounds(100,100, pacman1.getWidth(), pacman1.getHeight());

        }

    }

}