package Moteurs.physic;

import static junit.framework.TestCase.*;
import org.junit.Test;

public class CollisionManageTest{
    Pentity e1 = new Pentity(1, Type.SOLID,1,2,2,2,1);
    Pentity e2 = new Pentity(2,Type.SOLID, 0,1,2,2,1);
    Pentity e3 = new Pentity(3,Type.SOLID,3,4,2,2,1);
    Pentity e4 = new Pentity(4,Type.SOLID,4,2,2,2,1);

    /**
     * On test la détection de collision qu'importe le type de l'objet
     */
    @Test
    public void detectContactTestV1(){
        assertTrue(CollisionManage.detectContact( e1,  e2));
        assertTrue(CollisionManage.detectContact( e1,  e3));
        assertFalse(CollisionManage.detectContact( e1,  e4));
    }

    /**
     * On test les déplacements
     */
    @Test
    public void detectContactTestV2(){
        assertTrue(CollisionManage.detectContact( 3,2, e4,  e1));
        assertFalse(CollisionManage.detectContact( 5,2, e4,  e1));
    }

    /**
     * Il n'y a plus qu'a tester en fonction des Types
     */
    @Test
    public void detectCollisionTest(){
        Pentity e5 = new Pentity(1, Type.SOFT,1,2,2,2,1);
        Pentity e6 = new Pentity(1, Type.SOFT,1,2,2,2,1);

        assertFalse(CollisionManage.detectCollision(1,2,  e5,  e6));
        assertTrue(CollisionManage.detectCollision(1,2,  e1,  e6));
        assertTrue(CollisionManage.detectCollision(1,2,  e5,  e1));
        assertTrue(CollisionManage.detectCollision(1,2,  e1,  e1));

    }
  
}