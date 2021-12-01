package Moteurs.graphic;

import static junit.framework.TestCase.*;
import org.junit.Test;

public class GraphicTest {

    public GraphicEngine graphicEngine = new GraphicEngine();

    @Test
    public void createGraphicEntityTest(){
        assertTrue(graphicEngine.getEntities().isEmpty());
    }
}
