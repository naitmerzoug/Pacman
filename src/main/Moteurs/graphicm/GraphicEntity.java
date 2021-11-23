package Moteurs.graphicm;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Set;

/**
 * Entité graphique
 */
public class GraphicEntity {

    private int x; // Position x
    private int y; // Position y
    private int height;
    private int width;
    private Etat etat;
    //list image
    public HashMap<Etat, Set<BufferedImage>> images;

    private Color color;

    protected GraphicEntity(int x, int y, int height, int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    // Getters

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor(){
        return color;
    }

    // Setters

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}

