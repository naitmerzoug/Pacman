package Moteurs.graphic;

import org.junit.Test;
import javax.swing.*;
import java.awt.*;
import java.io.File;

import static org.junit.Assert.*;

/**
 * Tests du moteur graphique
 */
public class EngineGraphicTest {

    @Test
    public void creationScene() throws InterruptedException {
        GraphicEngine engineGraphic = new GraphicEngine(750, 500, Color.BLACK, "PacmanTest");
        engineGraphic.run();
        Thread.sleep(100);
        JPanel pacman1 = engineGraphic.createEntity(10, 10, new File("src/main/Pacman/Images/pacman.png"));
        engineGraphic.addEntity(pacman1, 100, 100);
    }

    @Test
    public void createAndAddEntityTest(){
        GraphicEngine engineGraphic = new GraphicEngine(50,40, Color.WHITE,"teste");
        JPanel jLabel = engineGraphic.createEntity(10,10,new File("src/main/Pacman/Images/pacman.png"));
        engineGraphic.addEntity(jLabel, 5, 10);
        assertEquals(5, engineGraphic.getAll()[0].getX());
        assertEquals(10, engineGraphic.getAll()[0].getY());

    }

    @Test
    public void mooveEntity(){
        GraphicEngine engineGraphic = new GraphicEngine(50,40, Color.WHITE,"teste");
        JPanel jLabel = engineGraphic.createEntity(10,10,new File("src/main/Pacman/Images/pacman.png"));
        engineGraphic.addEntity(jLabel, 5, 10);
        assertEquals(5, engineGraphic.getAll()[0].getX());
        assertEquals(10, engineGraphic.getAll()[0].getY());
        engineGraphic.setPositionEntity(jLabel, 50,80);
        assertEquals(50, engineGraphic.getAll()[0].getX());
        assertEquals(80, engineGraphic.getAll()[0].getY());
    }




}



