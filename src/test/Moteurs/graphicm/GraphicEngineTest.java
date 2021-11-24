package Moteurs.graphicm;

import org.junit.Test;

import java.awt.*;
import java.io.File;

public class GraphicEngineTest{

    @Test
    public void graphicSceneTest(){
        GraphicScene graphicScene = new GraphicScene(750, 750, Color.BLACK);
        graphicScene.run();
    }

    public static void main(String[] args) {
        GraphicScene graphicScene = new GraphicScene(750, 750, Color.BLACK);
        GraphicEntity entity = new GraphicEntity(150,100,10,10,new File("src\\main\\Moteurs\\graphicm\\pacman.png"));
        graphicScene.addEntity(entity);
        graphicScene.printEntities();
        graphicScene.run();
        entity.setPosition(100,100);
        graphicScene.printEntities();
        graphicScene.run();
        graphicScene.afficherScene();
    }

    @Test
    public void addEntityTest(){
        GraphicScene graphicScene = new GraphicScene(750, 750, Color.BLACK);
        GraphicEntity entity = new GraphicEntity(100,100,10,10,new File("src\\main\\Moteurs\\graphicm\\pacman.png"));
        graphicScene.addEntity(entity);
        entity.setPosition(100,100);
        graphicScene.run();
    }
}