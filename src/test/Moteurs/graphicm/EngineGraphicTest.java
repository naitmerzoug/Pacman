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
        EngineGraphic engineGraphic = new EngineGraphic(750, 500, Color.BLACK, "PacmanTest");
        //engineGraphic.run();
        System.out.println("sleep 1");
        Thread.currentThread().sleep(100);
        System.out.println("wake up 1");
        JLabel pacman1 = engineGraphic.createEntity(10,10,new File("C:\\Users\\flo-t\\IdeaProjects\\Pacman\\src\\main\\Moteurs\\graphicm\\pacman.png"));
        engineGraphic.addEntity(pacman1,100,100);
        engineGraphic.printEntities();
        for(Component components : engineGraphic.getAll())
            System.out.println(components.getX()+" "+components.getY());
        engineGraphic.run();

    }

}