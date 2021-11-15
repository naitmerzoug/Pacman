package Moteurs.graphic;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene extends JPanel {

    protected int height;
    protected int width;

    protected Graphics2D graphics2D;

    private final ArrayList<GraphicEntity> entityArrayList = new ArrayList<>();

    protected Scene(int width, int height){
        this.width = width;
        this.height = height;
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphics2D = (Graphics2D) g;
    }

    protected void addEntity(GraphicEntity entity){
        if (!entityArrayList.contains(entity)){
            entityArrayList.add(entity);
        }
    }

    protected void removeEntity(GraphicEntity entity){
        entityArrayList.remove(entity);
    }
}
