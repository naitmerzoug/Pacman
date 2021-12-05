package Moteurs.physic;

import java.util.ArrayList;
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
        physicEngine.createEntity(e1);
        physicEngine.createEntity(e2);
        physicEngine.createEntity(e3);
        physicEngine.createEntity(e4);
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
        physicEngine1.createEntity(e1);
        physicEngine1.createEntity(e2);
        physicEngine1.createEntity(e3);
        physicEngine1.createEntity(e4);


        physicEngine1.removeEntity(e2);


        assertFalse(physicEngine1.getEntities().containsKey(2));
    }

    /**
     * Test pour savoir si l'entité a pris la bonne direction
     */
    @org.junit.jupiter.api.Test
    void TESTCheckDirection() {
        PhysicEngine physicEngine2 = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 1, 1, 1);
        PhysicEntity e2 = new PhysicEntity(Type.SOLID, 3, 3, 1, 1, 1);
        PhysicEntity e3 = new PhysicEntity(Type.SOFT, 2, 2, 1, 1, 1);
        PhysicEntity e4 = new PhysicEntity(Type.SOFT, 3, 3, 1, 1, 1);
        physicEngine2.createEntity(e1);
        physicEngine2.createEntity(e2);
        physicEngine2.createEntity(e3);
        physicEngine2.createEntity(e4);

        physicEngine2.CheckDirection(e3, UP);
        assertFalse(physicEngine2.CheckDirection(e3, DIRECTION.DOWN));
        assertTrue(physicEngine2.CheckDirection(e3, DIRECTION.RIGHT));


    }

    /**
     * Test pour savoir une entité est bien placé
     */
    @org.junit.jupiter.api.Test
    void TESTentitiesAtPosition() {
        PhysicEngine physicEngine3 = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 1, 1, 1);
        PhysicEntity e2 = new PhysicEntity(Type.SOLID, 3, 3, 1, 1, 1);
        PhysicEntity e3 = new PhysicEntity(Type.SOFT, 2, 2, 1, 1, 1);
        PhysicEntity e4 = new PhysicEntity(Type.SOFT, 3, 3, 1, 1, 1);
        physicEngine3.createEntity(e1);
        physicEngine3.createEntity(e2);
        physicEngine3.createEntity(e3);
        physicEngine3.createEntity(e4);

        ArrayList<PhysicEntity> mesentities = new ArrayList<>();
        mesentities.add(e1);
        mesentities.add(e3);
        assertEquals(mesentities, physicEngine3.entitiesAtPosition(2, 2));

    }


    /**
     * Test de déplacement d'une entité
     */
    @org.junit.jupiter.api.Test
    void TESTmoving() {
        PhysicEngine physicEngine4 = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(1, Type.SOLID, 0, 0, 2, 2, 0.25);
        physicEngine4.move(e1, UP);
        assertEquals(0.25, e1.getPosY());

    }

    /**
     * Test du carré d'un nombre
     */
    @org.junit.jupiter.api.Test
    void TESTsqr() {
        double a = 2;
        assertEquals(4, PhysicEngine.sqr(a));
    }


    /**
     * Test de la distance entre deux points
     */
    @org.junit.jupiter.api.Test
    void TESTdistanceBetweenTowPoints() {
        PhysicEngine physicEngine6 = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 1, 1, 1);
        PhysicEntity e2 = new PhysicEntity(Type.SOLID, 3, 3, 1, 1, 1);
        assertEquals(Math.sqrt(2), physicEngine6.distanceBetweenTowPoints(e1, e2));
        assertNotEquals(Math.sqrt(5), physicEngine6.distanceBetweenTowPoints(e1, e2));
    }
}