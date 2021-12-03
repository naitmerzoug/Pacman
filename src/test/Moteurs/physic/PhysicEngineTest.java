package Moteurs.physic;

import Moteurs.physicm.DIRECTION;
import Moteurs.physicm.EnginePhysic;
import Moteurs.physicm.EntityPhysic;
import Moteurs.physicm.Type;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.junit.jupiter.api.Assertions.*;

class PhysicEngineTest {


    @org.junit.jupiter.api.Test
    void TESTcreateEntity() {
        EnginePhysic enginePhysic = new EnginePhysic();
        EntityPhysic e1 = new EntityPhysic( 1,2.0, 2.0, 1.0, 1.0, Type.SOLID,1.0);
        EntityPhysic e2 = new EntityPhysic(2, 3, 3, 1, 1,Type.SOLID, 1);
        EntityPhysic e3 = new EntityPhysic(3,2, 2, 1, 1,Type.SOFT,  1);
        EntityPhysic e4 = new EntityPhysic(4, 3, 3, 1, 1,Type.SOFT, 1);
        enginePhysic.createEntity(e1);
        enginePhysic.createEntity(e2);
        enginePhysic.createEntity(e3);
        enginePhysic.createEntity(e4);
        ConcurrentMap<Integer, EntityPhysic> mesentities = new ConcurrentHashMap<>();

        mesentities.put(e1.getId(), e1);
        mesentities.put(e2.getId(), e2);
        mesentities.put(e3.getId(), e3);
        mesentities.put(e4.getId(), e4);
        assertEquals(physicEngine.getEntities(), mesentities);

    }

    @org.junit.jupiter.api.Test
    void TESTremoveEntity() {
        EnginePhysic physicEngine1 = new EnginePhysic();

        EntityPhysic e1 = new EntityPhysic(1, 2, 2, 1, 1,Type.SOLID, 1);
        EntityPhysic e2 = new EntityPhysic( 2,3, 3, 1, 1,Type.SOLID, 1);
        EntityPhysic e3 = new EntityPhysic(3,2, 2, 1, 1, Type.SOFT, 1);
        EntityPhysic e4 = new EntityPhysic(4,3, 3, 1, 1, Type.SOFT, 1);
        physicEngine1.createEntity(e1);
        physicEngine1.createEntity(e2);
        physicEngine1.createEntity(e3);
        physicEngine1.createEntity(e4);


        physicEngine1.removeEntity(e2);


        assertFalse(physicEngine1.getEntities().containsKey(2));
    }

    @org.junit.jupiter.api.Test
    void TESTisSomething() {
        EnginePhysic physicEngine2 = new PhysicEngine();
        EntityPhysic e1 = new EntityPhysic( 1,2, 2, 1, 1,Type.SOLID, 1);
        EntityPhysic e2 = new EntityPhysic( 2,3, 3, 1, 1,Type.SOLID, 1);
        EntityPhysic e3 = new EntityPhysic(3,2, 2, 1, 1, Type.SOFT, 1);
        EntityPhysic e4 = new EntityPhysic(4,3, 3, 1, 1, Type.SOFT, 1);
        physicEngine2.createEntity(e1);
        physicEngine2.createEntity(e2);
        physicEngine2.createEntity(e3);
        physicEngine2.createEntity(e4);


        physicEngine2.isSomething(e3, DIRECTION.UP);
        assertFalse(physicEngine2.isSomething(e3, DIRECTION.DOWN));
        assertTrue(physicEngine2.isSomething(e3, DIRECTION.RIGHT));


    }

    @org.junit.jupiter.api.Test
    void TESTentitiesAtPosition() {
        EnginePhysic physicEngine3 = new EnginePhysic();
        EntityPhysic e1 = new EntityPhysic(1, 2, 2, 1, 1,Type.SOLID,1);
        EntityPhysic e2 = new EntityPhysic( 2,3, 3, 1, 1,Type.SOLID,1);
        EntityPhysic e3 = new EntityPhysic(3,2, 2, 1, 1, Type.SOFT, );
        EntityPhysic e4 = new EntityPhysic(4,3, 3, 1, 1, Type.SOFT, );
        physicEngine3.createEntity(e1);
        physicEngine3.createEntity(e2);
        physicEngine3.createEntity(e3);
        physicEngine3.createEntity(e4);

        ArrayList<EntityPhysic> mesentities = new ArrayList<>();
        mesentities.add(e1);
        mesentities.add(e3);
        assertEquals(mesentities, physicEngine3.entitiesAtPosition(2, 2));

    }

    @org.junit.jupiter.api.Test
    void TESTtestEntitiesAtPosition() {
        EnginePhysic physicEngine4 = new EnginePhysic();
        EntityPhysic e1 = new EntityPhysic( 1,2, 2, 2,   2,Type.SOLID,1);
        EntityPhysic e2 = new EntityPhysic(2, 3.5, 2, 2, 2,Type.SOLID,1);
        EntityPhysic e3 = new EntityPhysic(3,10, 10, 1, 1, Type.SOFT, 1);
        EntityPhysic e4 = new EntityPhysic(4,7, 7, 1, 1,   Type.SOFT, 1);
        physicEngine4.createEntity(e1);
        physicEngine4.createEntity(e2);
        physicEngine4.createEntity(e3);
        physicEngine4.createEntity(e4);
        ArrayList<EntityPhysic> mesentities = new ArrayList<>();
        mesentities.add(e1);
        mesentities.add(e2);
        assertEquals(mesentities, physicEngine4.entitiesAtPosition(2, 2, 2, 2));

    }



    @org.junit.jupiter.api.Test
    void TESTmoving() {
        EnginePhysic physicEngine4 = new EnginePhysic();
        EntityPhysic e1 = new EntityPhysic(1,2, 2, 2, 2, Type.SOLID, 5);
        physicEngine4.moving(e1, 1, 0);
        assertEquals(7, e1.getPosX());

    }

    @org.junit.jupiter.api.Test
    void TESTmove() {
        EnginePhysic physicEngine5 = new EnginePhysic();
        EntityPhysic e1 = new EntityPhysic(1, 2, 2, 2, 2, Type.SOLID, 6);
        physicEngine5.move(e1, DIRECTION.UP);
        assertEquals(8, e1.getPosY());

    }

    @org.junit.jupiter.api.Test
    void TESTsqr() {
        double a = 2;
        assertEquals(4, EnginePhysic.sqr(a));
    }



    @org.junit.jupiter.api.Test
    void TESTdistanceBetweenTowPoints() {
        EnginePhysic physicEngine6 = new EnginePhysic();
        EntityPhysic e1 = new EntityPhysic(1, 2, 2, 1, 1,Type.SOLID,  1);
        EntityPhysic e2 = new EntityPhysic(2, 3, 3, 1, 1, Type.SOLID, 1);
        assertEquals(Math.sqrt(2), physicEngine6.distanceBetweenTowPoints(e1, e2));
        assertNotEquals(Math.sqrt(5), physicEngine6.distanceBetweenTowPoints(e1, e2));
    }
}