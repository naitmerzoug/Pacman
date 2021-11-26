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
//        graphicScene.printEntities();
        graphicScene.run();
        for(Component i : graphicScene.getComponents())
            System.out.println(i.getX() + " " + i.getY());
        entity.setPosition(80,100);
        for(Component i : graphicScene.getComponents())
            System.out.println(i.getX() + " " + i.getY());
        for(Component i : graphicScene.getComponents())
            i.setLocation(100,150);
        for(Component i : graphicScene.getComponents())
            System.out.println(i.getX() + " " + i.getY());
        //System.out.println(entity.getX() + " "+entity.getY());
//      graphicScene.printEntities();
         graphicScene.run();
//        graphicScene.afficherScene();
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