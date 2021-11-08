package Moteurs.physic;

import java.util.Vector;

public class Entity {

    private double posX;
    private double posY;

    private double length;
    private double width;

    public Entity(double posX, double posY,double length, double width){
        this.posX = posX;
        this.posY = posY;
        this.length = length;
        this.width = width;

    }

    public double getPosX(){
        return posX;
    }

    public double getPosY(){
        return posY;
    }

    public double getLength(){
        return length;
    }

    public double getWidth(){
        return width;
    }



}
