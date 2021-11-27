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

        entity.setPosition(80,100);

        for(Component i : graphicScene.getComponents())
            System.out.println(i.getX() + " " + i.getY());

        for(Component i : graphicScene.getComponents())
            i.setBounds(100,150, i.getWidth(), i.getHeight());

        for(Component i : graphicScene.getComponents())
            System.out.println(i.getX() + " " + i.getY());
        //System.out.println(entity.getX() + " "+entity.getY());
//      graphicScene.printEntities();

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