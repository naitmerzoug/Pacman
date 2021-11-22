package Moteurs.graphic;

import java.awt.*;

/**
 * Entité graphique
 */
public class GraphicEntity {

    private int x; // Position x
    private int y; // Position y
    private int height;
    private int width;

    private Color color;

    protected GraphicScene scene;

    protected GraphicEntity(int id, int x, int y, int height, int width){ 
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

    public GraphicScene getScene() {
        return scene;
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

    public void setScene(GraphicScene scene) { this.scene = scene; }
}
