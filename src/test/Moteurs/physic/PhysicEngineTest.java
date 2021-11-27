package Moteurs.physic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.junit.jupiter.api.Assertions.*;

class PhysicEngineTest {


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

        mesentities.put(1, e1);
        mesentities.put(2, e2);
        mesentities.put(3, e3);
        mesentities.put(4, e4);
        assertEquals(4, e4.getId());
        assertEquals(physicEngine.getEntities(), mesentities);

    }

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

    @org.junit.jupiter.api.Test
    void TESTisSomething() {
        PhysicEngine physicEngine = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 1, 1, 1);
        PhysicEntity e2 = new PhysicEntity(Type.SOLID, 3, 3, 1, 1, 1);
        PhysicEntity e3 = new PhysicEntity(Type.SOFT, 2, 2, 1, 1, 1);
        PhysicEntity e4 = new PhysicEntity(Type.SOFT, 3, 3, 1, 1, 1);
        physicEngine.createEntity(e1);
        physicEngine.createEntity(e2);
        physicEngine.createEntity(e3);
        physicEngine.createEntity(e4);


        physicEngine.isSomething(e3, DIRECTION.UP);
        assertFalse(physicEngine.isSomething(e3, DIRECTION.DOWN));
        assertTrue(physicEngine.isSomething(e3, DIRECTION.RIGHT));


    }

    @org.junit.jupiter.api.Test
    void TESTentitiesAtPosition() {
        PhysicEngine physicEngine = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 1, 1, 1);
        PhysicEntity e2 = new PhysicEntity(Type.SOLID, 3, 3, 1, 1, 1);
        PhysicEntity e3 = new PhysicEntity(Type.SOFT, 2, 2, 1, 1, 1);
        PhysicEntity e4 = new PhysicEntity(Type.SOFT, 3, 3, 1, 1, 1);
        physicEngine.createEntity(e1);
        physicEngine.createEntity(e2);
        physicEngine.createEntity(e3);
        physicEngine.createEntity(e4);

        ArrayList<PhysicEntity> mesentities = new ArrayList<>();
        mesentities.add(e1);
        mesentities.add(e3);
        assertEquals(mesentities, physicEngine.entitiesAtPosition(2, 2));

    }

    @org.junit.jupiter.api.Test
    void TESTtestEntitiesAtPosition() {
        PhysicEngine physicEngine = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 2, 2, 1);
        PhysicEntity e2 = new PhysicEntity(Type.SOLID, 3.5, 2, 2, 2, 1);
        PhysicEntity e3 = new PhysicEntity(Type.SOFT, 10, 10, 1, 1, 1);
        PhysicEntity e4 = new PhysicEntity(Type.SOFT, 7, 7, 1, 1, 1);
        physicEngine.createEntity(e1);
        physicEngine.createEntity(e2);
        physicEngine.createEntity(e3);
        physicEngine.createEntity(e4);
        ArrayList<PhysicEntity> mesentities = new ArrayList<>();
        mesentities.add(e1);
        mesentities.add(e2);
        assertEquals(mesentities, physicEngine.entitiesAtPosition(2, 2, 2, 2));

    }

    @org.junit.jupiter.api.Test
    void TESTmoving() {
        PhysicEngine physicEngine = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 2, 2, 5);
        physicEngine.moving(e1, 1, 0);
        assertEquals(7, e1.getPosX());

    }

    @org.junit.jupiter.api.Test
    void TESTmove() {
        PhysicEngine physicEngine = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 2, 2, 5);
        physicEngine.move(e1, DIRECTION.UP);
        assertEquals(7, e1.getPosY());

    }

    @org.junit.jupiter.api.Test
    void TESTsqr() {
        double a = 2;
        assertEquals(4, PhysicEngine.sqr(a));
    }


    @org.junit.jupiter.api.Test
    void TESTdistanceBetweenTowPoints() {
        PhysicEngine physicEngine = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 1, 1, 1);
        PhysicEntity e2 = new PhysicEntity(Type.SOLID, 3, 3, 1, 1, 1);
        assertEquals(Math.sqrt(2), physicEngine.distanceBetweenTowPoints(e1, e2));
        assertNotEquals(Math.sqrt(5), physicEngine.distanceBetweenTowPoints(e1, e2));
    }
}