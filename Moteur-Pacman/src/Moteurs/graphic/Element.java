package Moteurs.graphic;

import javax.swing.*;
import java.awt.*;

public class Element {
    private int x;
    private int y;
    private int size;
    private String color;

    public Element(int x, int y, int size, String color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;

    }


    /* Getter */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize(){
        return size;
    }

    public String getColor() {
        return color;
    }

    /* Setter */

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y){
        this.y = x;
    }
}
