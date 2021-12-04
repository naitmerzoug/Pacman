
package Moteurs.physic;

import static junit.framework.TestCase.*;
import org.junit.Test;

public class CollisionManageTest{

    /**
     * Test de la détection de contact (le type de l'objet n'est pas pris en compte)
     */
    @Test
    public void detectContactTest(){
        PhysicEntity e1 = new PhysicEntity(1, Type.SOLID,1,2,2,2,1);
        PhysicEntity e4 = new PhysicEntity(4,Type.SOLID,4,2,2,2,1);

        assertTrue(CollisionManage.detectContact( 3,2, e4,  e1));
        assertFalse(CollisionManage.detectContact( 5,2, e4,  e1));
    }


    /**
     * Test de la collision entre objets selon leur type
     */
    @Test
    public void detectCollisionTest(){
        PhysicEntity e1 = new PhysicEntity(1, Type.SOLID,1,2,2,2,1);
        PhysicEntity e5 = new PhysicEntity(1, Type.SOFT,1,2,2,2,1);
        PhysicEntity e6 = new PhysicEntity(1, Type.SOFT,1,2,2,2,1);


        assertFalse(CollisionManage.detectCollision(1,2,  e5,  e6));
        assertTrue(CollisionManage.detectCollision(1,2,  e1,  e6));
        assertTrue(CollisionManage.detectCollision(1,2,  e5,  e1));
        assertTrue(CollisionManage.detectCollision(1,2,  e1,  e1));


    }


}

