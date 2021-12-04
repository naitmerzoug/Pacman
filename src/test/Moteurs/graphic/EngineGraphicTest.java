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

    /**
     * Test de la création d'une scène
     */
    @Test
    public void creationScene() throws InterruptedException {
        GraphicEngine engineGraphic = new GraphicEngine(750, 500, Color.BLACK, "PacmanTest");
        engineGraphic.run();
        Thread.sleep(100);
        JPanel pacman1 = engineGraphic.createEntity(10, 10, new File("src/main/Pacman/Images/pacman.png"));
        engineGraphic.addEntity(pacman1, 100, 100);
    }

    /**
     * Test du déplacement d'une entité
     */
    @Test
    public void moveEntity(){
        GraphicEngine engineGraphic = new GraphicEngine(50,40, Color.WHITE,"PacmanTest");
        JPanel entity = engineGraphic.createAndAddEntity(10,10,10, 10,new File("src/main/Pacman/Images/pacman.png"));
        engineGraphic.setPositionEntity(entity, 20, 20);
        assertEquals(20, entity.getX());
    }




}



