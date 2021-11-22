package Moteurs.graphicm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class GraphicScene extends JPanel {

    protected int height; // hauteur de la scene
    protected int width;  // largeur de la scene

    protected Graphics2D graphics2D;

    private final ArrayList<GraphicEntity> entityArrayList = new ArrayList<>();  // liste des entites graphiques

    protected GraphicScene(int width, int height){
        this.width = width;
        this.height = height;
        setBackground(Color.BLACK);
    }

    /**
     * Ajoute une entité graphique à la scène
     */
    protected void addEntity(GraphicEntity entity){
        if (!entityArrayList.contains(entity)){
            entityArrayList.add(entity);
        }
    }

    /**
     * Supprime une entité graphique à la scène
     */
    protected void removeEntity(GraphicEntity entity){
        entityArrayList.remove(entity);
    }

}
