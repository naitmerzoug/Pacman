package Moteurs.graphic;

import static junit.framework.TestCase.*;

import Moteurs.core.Entity;
import org.junit.Test;

import java.awt.*;

public class GraphicTest {

    GraphicEngine graphicEngine = new GraphicEngine(750,500, Color.BLACK,"PacmanTest");


    @Test
    public void assertFirstGEntityCreated(){
        assertTrue(graphicEngine.getEntities().isEmpty());
        //Gentity newEntity = graphicEngine.createEntity(entity);
        assertEquals(1, graphicEngine.getEntities().size());
    }

    @Test
    public void assertGEntityRemoved(){
        //Gentity newEntity = graphicEngine.createEntity(entity);
        int graphicEngineEntitiesSize = graphicEngine.getEntities().size();
        //graphicEngine.removeEntity(newEntity);
        assertEquals(graphicEngineEntitiesSize-1, graphicEngine.getEntities().size());
    }

}
