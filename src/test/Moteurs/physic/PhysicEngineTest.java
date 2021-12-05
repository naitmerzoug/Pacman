package Moteurs.physic;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static Moteurs.physic.DIRECTION.UP;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests du moteur physique
 */
class PhysicEngineTest {

    /**
     * Test de la création d'une entité
     */
    @org.junit.jupiter.api.Test
    void TESTcreateEntity() {
        PhysicEngine physicEngine = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 1, 1, 1);
        PhysicEntity e2 = new PhysicEntity(Type.SOLID, 3, 3, 1, 1, 1);
        PhysicEntity e3 = new PhysicEntity(Type.SOFT, 2, 2, 1, 1, 1);
        PhysicEntity e4 = new PhysicEntity(Type.SOFT, 3, 3, 1, 1, 1);
        physicEngine.addEntity(e1);
        physicEngine.addEntity(e2);
        physicEngine.addEntity(e3);
        physicEngine.addEntity(e4);
        ConcurrentMap<Integer, PhysicEntity> mesentities = new ConcurrentHashMap<>();

        mesentities.put(e1.getId(), e1);
        mesentities.put(e2.getId(), e2);
        mesentities.put(e3.getId(), e3);
        mesentities.put(e4.getId(), e4);
        assertEquals(physicEngine.getEntities(), mesentities);

    }

    /**
     * Test de la suppression d'une entité
     */
    @org.junit.jupiter.api.Test
    void TESTremoveEntity() {
        PhysicEngine physicEngine1 = new PhysicEngine();

        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 1, 1, 1);
        PhysicEntity e2 = new PhysicEntity(Type.SOLID, 3, 3, 1, 1, 1);
        PhysicEntity e3 = new PhysicEntity(Type.SOFT, 2, 2, 1, 1, 1);
        PhysicEntity e4 = new PhysicEntity(Type.SOFT, 3, 3, 1, 1, 1);
        physicEngine1.addEntity(e1);
        physicEngine1.addEntity(e2);
        physicEngine1.addEntity(e3);
        physicEngine1.addEntity(e4);

        physicEngine1.removeEntity(e2);

        assertFalse(physicEngine1.getEntities().containsKey(2));
    }


    /**
     * Test de déplacement d'une entité
     */
    @org.junit.jupiter.api.Test
    void TestMove() {
        PhysicEngine physicEngine4 = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(1, Type.SOLID, 0, 0, 2, 2, 0.25);
        physicEngine4.move(e1, UP);
        assertEquals(0.25, e1.getPosY());

    }

    /**
     * Test de collision d'une entité
     */
    @org.junit.jupiter.api.Test
    void TestIsCollision() {
        PhysicEngine physicEngine5 = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(2, Type.SOLID, 0, 0, 2, 2, 0.25);
        physicEngine5.addEntity(e1);
        assertTrue(physicEngine5.IsCollision(e1.getId(),1,1,2,2));

    }



}