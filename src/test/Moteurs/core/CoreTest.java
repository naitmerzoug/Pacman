package Moteurs.core;

import Moteurs.physic.Type;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoreTest {


    /**
     * Test si le nombre d'entités du moteur noyau est correct
     */
    @Test
    public void TestAddEntity(){
        Moteurs.core.CoreEngine coreEngine = new Moteurs.core.CoreEngine("Game",20,20);
        CoreEntity e1 = coreEngine.createAndAddEntity(Type.SOFT, 1,1,10,10, 1,new File("src/main/Pacman/Images/pacman.png"));
        CoreEntity e2 = coreEngine.createAndAddEntity(Type.SOFT, 1,1,10,10, 1,new File("src/main/Pacman/Images/pacman.png"));
        CoreEntity e3 = coreEngine.createAndAddEntity(Type.SOFT, 1,1,10,10, 1,new File("src/main/Pacman/Images/pacman.png"));
        assertEquals(3, CoreEngine.getNbEntities());
    }

    /**
     * Test si les Id des entités noyaux sont correctement attribués
     */
    @Test
    public void TestEntityId(){
        Moteurs.core.CoreEngine coreEngine = new Moteurs.core.CoreEngine("Game",20,20);
        CoreEntity e1 = coreEngine.createAndAddEntity(Type.SOFT, 1,1,10,10, 1, new File("src/main/Pacman/Images/pacman.png"));
        CoreEntity e2 = coreEngine.createAndAddEntity(Type.SOFT, 1,1,10,10, 1, new File("src/main/Pacman/Images/pacman.png"));
        assertEquals(2, e2.getId());
    }

    @Test
    public void TestRemoveEntity(){
        Moteurs.core.CoreEngine coreEngine = new Moteurs.core.CoreEngine("Game",20,20);
        CoreEntity e1 = coreEngine.createAndAddEntity(Type.SOFT, 1,1,10,10, 1, new File("src/main/Pacman/Images/pacman.png"));
        coreEngine.removeEntity(e1);
        System.out.println(coreEngine.getGraphicEngine().getFrame().getComponents());
        Assertions.assertAll(
                () ->  assertTrue(coreEngine.getEntities().isEmpty()),
                () ->  assertTrue(coreEngine.getPhysicEngine().getEntities().isEmpty()),
                () ->  assertEquals(coreEngine.getGraphicEngine().getFrame().getComponentCount(), 0)
        );

    }

    /**
     * Test si la conversion de l'espace physique à l'espace graphique est correct (axe des abscisses)
     */
    @Test
    public void TestConvertCoord(){
        Moteurs.core.CoreEngine coreEngine = new Moteurs.core.CoreEngine("Game",50,50);
        assertEquals(200, coreEngine.ConvertPhysictoGraphic(20));

    }

    /**
     * Test si la conversion de l'espace physique à l'espace graphique est correct (axe des ordonnées)
     */
    @Test
    public void TestConvertCoordOrd(){
        Moteurs.core.CoreEngine coreEngine = new Moteurs.core.CoreEngine("Game",50,50);
        assertEquals(100, coreEngine.ConvertPhysictoGraphicOrd(-10));

    }
}
