package Moteurs.physic;

import java.util.HashSet;
import java.util.Set;

public class Pentity {

    private int id;
    private double posX;
    private double posY;
    private double length;
    private double width;
    private int speed;
    private Type type;
    private Set<Pentity> collisions; // mur, fantome, fruit


    public Pentity(int id, Type type, double posX, double posY, double length, double width, int speed){
        this.type = type;
        this.posX = posX;
        this.posY = posY;
        this.length = length;
        this.width = width;
        this.id= id;
        this.collisions = new HashSet<>();
        this.speed = speed;
    }

    public Type getType() {
        return type;
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

    public Set<Pentity> getCollisions(){
        return collisions;
    }

    public void addCollisions(Pentity pentity){collisions.add(pentity);}



}
