package Moteurs.core;

import Moteurs.Game;
import Moteurs.physic.Type;
import PacmanGame.Main;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CoreTest {
    Game game;

    /**
     * Test si le nombre d'entités du moteur noyau est correct
     */
    @Test
    public void TestAddEntity(){
        Moteurs.core.CoreEngine c1 = new Moteurs.core.CoreEngine(2,2,200,200,game);
        CoreEntity e1 = c1.addEntity(Type.SOFT, 1,1,10,10, 1,new File("src/main/Pacman/Images/pacman.png"));
        CoreEntity e2 = c1.addEntity(Type.SOFT, 1,1,10,10, 1,new File("src/main/Pacman/Images/pacman.png"));
        CoreEntity e3 = c1.addEntity(Type.SOFT, 1,1,10,10, 1,new File("src/main/Pacman/Images/pacman.png"));
        assertEquals(3, CoreEngine.getNbEntities());
    }

    /**
     * Test si les Id des entités noyaux sont correctement attribués
     */
    @Test
    public void TestEntityId(){
        Moteurs.core.CoreEngine coreEngine = new Moteurs.core.CoreEngine(2,2,200,200,game);
        CoreEntity e1 = coreEngine.addEntity(Type.SOFT, 1,1,10,10, 1, new File("src/main/Pacman/Images/pacman.png"));
        CoreEntity e2 = coreEngine.addEntity(Type.SOFT, 1,1,10,10, 1, new File("src/main/Pacman/Images/pacman.png"));
        assertEquals(2, e2.getId());
    }

    @Test
    public void TestRemoveEntity(){
        CoreEngine coreEngine = new CoreEngine(2,2,200,200, game);
        CoreEntity e1 = coreEngine.addEntity(Type.SOFT, 1,1,10,10, 1, new File("src/main/Pacman/Images/pacman.png"));
        coreEngine.removeEntity(e1);
        Assertions.assertAll(
                () ->  assertTrue(coreEngine.getEntities().isEmpty()),
                () ->  assertTrue(coreEngine.getPhysicEngine().getEntities().isEmpty()),
                () ->  assertEquals(coreEngine.getGraphicEngine().getjPanel().getComponentCount(), 0)
        );

    }

    /**
     * Test si la conversion de l'espace physique à l'espace graphique est correct (axe des abscisses)
     */
    @Test
    public void TestConvertCoord(){
        Moteurs.core.CoreEngine coreEngine = new Moteurs.core.CoreEngine(5,5,500,500,game);
        assertEquals(200, coreEngine.ConvertPhysictoGraphic(2));

    }

    /**
     * Test si la conversion de l'espace physique à l'espace graphique est correct (axe des ordonnées)
     */
    @Test
    public void TestConvertCoordOrd(){
        Moteurs.core.CoreEngine coreEngine = new Moteurs.core.CoreEngine(5,5,500,500,new Main());
        assertEquals(100, coreEngine.ConvertPhysictoGraphicOrd(-1));

    }
}
