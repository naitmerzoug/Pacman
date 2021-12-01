package Moteurs.core;

import static junit.framework.TestCase.*;

import Moteurs.physic.Type;
import org.junit.Test;

public class CoreTest {

    /**
     * Test si le nombre d'entités du moteur noyau est correct
     */
    @Test
    public void TestAddEntity(){
        Moteurs.core.CoreEngine c1 = new Moteurs.core.CoreEngine(2,2,200,200);
        CoreEntity e1 = c1.addEntity(Type.SOFT, 1,1,10,10, 1);
        CoreEntity e2 = c1.addEntity(Type.SOFT, 1,1,10,10, 1);
        CoreEntity e3 = c1.addEntity(Type.SOFT, 1,1,10,10, 1);
        assertEquals(3, c1.getNbEntities());
    }

    /**
     * Test si les Id des entités noyaux sont correctement attribués
     */
    @Test
    public void TestEntityId(){
        Moteurs.core.CoreEngine coreEngine = new Moteurs.core.CoreEngine(2,2,200,200);
        CoreEntity e1 = new CoreEntity();
        CoreEntity e2 = new CoreEntity();
        coreEngine.addEntity(Type.SOFT, 1,1,10,10, 1);
        coreEngine.addEntity(Type.SOFT, 1,1,10,10, 1);
        assertEquals(2, e2.getId());

    }

    /**
     * Test si la conversion de l'espace physique à l'espace graphique est correct (axe des abscisses)
     */
    @Test
    public void TestConvertCoord(){
        Moteurs.core.CoreEngine coreEngine = new Moteurs.core.CoreEngine(5,5,500,500);
        assertEquals(200, coreEngine.ConvertPhysictoGraphic(2));

    }

    /**
     * Test si la conversion de l'espace physique à l'espace graphique est correct (axe des ordonnées)
     */
    @Test
    public void TestConvertCoordOrd(){
        Moteurs.core.CoreEngine coreEngine = new Moteurs.core.CoreEngine(5,5,500,500);
        assertEquals(100, coreEngine.ConvertPhysictoGraphicOrd(-1));

    }
}
