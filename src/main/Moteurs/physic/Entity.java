package Moteurs.physic;

import java.util.HashSet;
import java.util.Set;

public class Entity {

    private int id;
    private double posX;
    private double posY;
    private double length;
    private double width;
    private int speed;
    private boolean collided;
    private Set<Entity> collisions;


    public Entity(int id,double posX, double posY,double length, double width){
        this.posX = posX;
        this.posY = posY;
        this.length = length;
        this.width = width;
        this.id= id;
        this.collisions = new HashSet<>();

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

    public int getId() {
        return id;
    }

    public int getSpeed() {
        return speed;
    }

    public Set<Entity> getCollisions(){
        return collisions;
    }

}
