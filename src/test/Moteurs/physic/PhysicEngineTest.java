package Moteurs.physic;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static junit.framework.TestCase.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;


class PhysicEngineTest  {


   @Test
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
       PhysicEngine physicEngine2 = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 1, 1, 1);
        PhysicEntity e2 = new PhysicEntity(Type.SOLID, 3, 3, 1, 1, 1);
        PhysicEntity e3 = new PhysicEntity(Type.SOFT, 2, 2, 1, 1, 1);
       PhysicEntity e4 = new PhysicEntity(Type.SOFT, 3, 3, 1, 1, 1);
        physicEngine2.createEntity(e1);
        physicEngine2.createEntity(e2);
        physicEngine2.createEntity(e3);
        physicEngine2.createEntity(e4);


        physicEngine2.isSomething(e3, DIRECTION.UP);
        assertFalse(physicEngine2.isSomething(e3, DIRECTION.DOWN));
        assertTrue(physicEngine2.isSomething(e3, DIRECTION.RIGHT));


    }

    @Test
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

    @Test
    void TESTtestEntitiesAtPosition() {
        PhysicEngine physicEngine4 = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 2, 2, 1);
        PhysicEntity e2 = new PhysicEntity(Type.SOLID, 3.5, 2, 2, 2, 1);
        PhysicEntity e3 = new PhysicEntity(Type.SOFT, 10, 10, 1, 1, 1);
        PhysicEntity e4 = new PhysicEntity(Type.SOFT, 7, 7, 1, 1, 1);
        physicEngine4.createEntity(e1);
        physicEngine4.createEntity(e2);
        physicEngine4.createEntity(e3);
        physicEngine4.createEntity(e4);
        ArrayList<PhysicEntity> mesentities = new ArrayList<>();
        mesentities.add(e1);
        mesentities.add(e2);
        assertEquals(mesentities, physicEngine4.entitiesAtPosition(2, 2, 2, 2));

    }

    @Test
    void TESTmoving() {
        PhysicEngine physicEngine4 = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 2, 2, 5);
        physicEngine4.moving(e1, 1, 0);
        assertEquals(7, e1.getPosX());

    }

    @Test
    void TESTmove() {
       PhysicEngine physicEngine5 = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 2, 2, 5);
        physicEngine5.move(e1, DIRECTION.UP);
        assertEquals(7, e1.getPosY());

    }

    @Test
    void TESTsqr() {
        double a = 2;
        assertEquals(4, PhysicEngine.sqr(a));
   }


    @Test
    void TESTdistanceBetweenTowPoints() {
        PhysicEngine physicEngine6 = new PhysicEngine();
        PhysicEntity e1 = new PhysicEntity(Type.SOLID, 2, 2, 1, 1, 1);
        PhysicEntity e2 = new PhysicEntity(Type.SOLID, 3, 3, 1, 1, 1);
        assertEquals(Math.sqrt(2), physicEngine6.distanceBetweenTowPoints(e1, e2));
        assertNotEquals(Math.sqrt(5), physicEngine6.distanceBetweenTowPoints(e1, e2));
    }
}