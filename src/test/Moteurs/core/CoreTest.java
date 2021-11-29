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
        CoreEngine c1 = new CoreEngine();
        CoreEntity e1 = new CoreEntity(Type.SOFT, 1,1,10,10, 1);
        CoreEntity e2 = new CoreEntity(Type.SOFT, 1,1,10,10, 1);
        CoreEntity e3 = new CoreEntity(Type.SOFT, 1,1,10,10, 1);
        c1.addEntity(e1);
        c1.addEntity(e2);
        c1.addEntity(e3);
        assertEquals(3, c1.getNbEntities());
    }

    /**
     * Test si les Id des entités noyaux sont correctement attribués
     */
    @Test
    public void TestEntityId(){
        CoreEngine coreEngine = new CoreEngine();
        CoreEntity e1 = new CoreEntity(Type.SOFT, 2,1,10,10, 1);
        CoreEntity e2 = new CoreEntity(Type.SOFT, 2,1,10,10, 1);
        coreEngine.addEntity(e1);
        coreEngine.addEntity(e2);
        assertEquals(2, e2.getId());

    }
}
