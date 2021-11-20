package Moteurs.physic;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class PhysicsTest {
    /**
     * Ici nous ne testerons pas les si les collisions sont valide mais uniquement si les methodes de Physic retourne
     * des réponses exact en fonction des informations obtenus
     * Pas de test sur les tailles des objets, leurs vitesses ou leurs créations.
     * Required:
     * CollissionManage Valide (tested)
     */
    public Physic physic = new Physic();
    /* Objet Solide 1  */
    private static Pentity solid_1_1 = new Pentity(1, Type.SOLID, 0, 0, 1, 1, 1);
    /* Objet Solide 2 */
    private static Pentity solid_1_2  = new Pentity(2, Type.SOLID, 1, 1, 1, 1, 1);
    /* Objet Mou    3 */
    private static Pentity soft_1_3  = new Pentity(3, Type.SOFT, -1, 1, 1, 1, 1);


    /* Objet Mou    1 */
    private static Pentity soft_2_1  = new Pentity(1, Type.SOFT, 10, 0, 1, 1, 1);
    /* Objet Mou    2 */
    private static Pentity soft_2_2  = new Pentity(1, Type.SOFT, 11, 1, 1, 1, 1);
    /* Objet Solide 4 */
    private static Pentity solid_2_3  = new Pentity(2, Type.SOLID, 9, 1, 1, 1, 1);

    public static void main(String[] args) {
//        Physic physic = new Physic();
//        /* PacMan  */physic.createEntity(1, Type.SOLID, 2, 2, 3, 3, 1);
//        /* Ghots_1 */physic.createEntity(2, Type.SOFT, 2, 3, 3, 3, 1);
//        /* Ghots_2 */physic.createEntity(3, Type.SOFT, 15, 15, 3, 3, 1);
//        /* Wall_0  */physic.createEntity(4, Type.SOLID, 15, 15, 3, 3, 0);
//
//        for(Pentity entity : physic.getAllWorld())
//            entity.print();
//        e1.setPositionPoints(0, 0);
//
//        assertEquals(2,2);
    }

    @Test
    public void createEntityTest() {
        Physic physic = new Physic();
        /* PacMan  */physic.createEntity(1, Type.SOLID, 2, 2, 3, 3, 1);
        Pentity pentity = new Pentity(1, Type.SOLID, 2, 2, 3, 3, 1);
        Pentity test = physic.get(1);
        assertEquals(pentity.getPosX(),test.getPosX());
        assertEquals(pentity.getPosY(),test.getPosY());
        assertEquals(pentity.getId(),test.getId());
        assertEquals(pentity.getSpeed(),test.getSpeed());
        assertEquals(pentity.getLength(),test.getLength());
        assertEquals(pentity.getWidth(),test.getWidth());
    }

    @Test
    public void addTest(){
        Physic physic2 = new Physic();
        /* PacMan  */physic2.createEntity(1, Type.SOLID, 2, 2, 3, 3, 1);
        assertFalse(physic2.add(solid_1_1));
        assertTrue(physic2.add(solid_1_2));
    }

    @Test
    public void positionIsReachableTest() {
        physic.add(solid_1_1);
        physic.add(solid_1_2);
        physic.add(soft_1_3);
        assertTrue(physic.positionIsReachable(solid_1_1, DIRECTION.RIGHT));
        physic.setPosition(solid_1_1, DIRECTION.RIGHT);
        assertFalse(physic.positionIsReachable(solid_1_1, DIRECTION.UP));
        assertFalse(physic.positionIsReachable(solid_1_1, DIRECTION.DOWN));

        physic.add(soft_2_1);
        physic.add(soft_2_2);
        physic.add(solid_2_3);
        assertTrue(physic.positionIsReachable(soft_2_1, DIRECTION.RIGHT));
        physic.setPosition(soft_2_1, DIRECTION.RIGHT);
        assertFalse(physic.positionIsReachable(soft_2_1, DIRECTION.UP));
        assertFalse(physic.positionIsReachable(soft_2_1, DIRECTION.DOWN));

    }

    @Test
    public void getObjectCollisionTest(){
        physic.add(solid_1_1);
        physic.add(solid_1_2);
        physic.add(soft_1_3);
        physic.setPosition(solid_1_1, DIRECTION.RIGHT);
        assertFalse(physic.positionIsReachable(solid_1_1, DIRECTION.UP));
        assertEquals(physic.get(2),physic.getObjectCollision(solid_1_1, DIRECTION.UP));
        physic.getObjectCollision(solid_1_1, DIRECTION.UP).print();
        
        assertFalse(physic.positionIsReachable(solid_1_1, DIRECTION.DOWN));
    }

    @Test
    public void createEntityV2(){
        assertTrue(physic.createEntity(1, Type.SOLID, 2, 2, 3, 3, 1));
        assertFalse(physic.createEntity(1, Type.SOLID, 2, 2, 3, 3, 1));
        assertFalse( physic.add(solid_1_1));
        physic.createEntity(Type.SOLID, 2, 2, 3, 3, 1);
        assertEquals(2,physic.get(2).getId());
        physic.printWord();
    }
}
