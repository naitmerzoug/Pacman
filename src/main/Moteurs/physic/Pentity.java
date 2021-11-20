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

    /**
     *
     * @param id int
     * @param type Type
     * @param posX double
     * @param posY double
     * @param length double
     * @param width double
     * @param speed int
     */
    public Pentity(int id, Type type, double posX, double posY, double length, double width, int speed){
        this.type = type;
        this.posX = posX;
        this.posY = posY;
        this.length = length;
        this.width = width;
        this.id= id;
        this.collisions = new HashSet<>(); // inutilisé, à supr ?
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

    // inutilisé, à supr ?
    public Set<Pentity> getCollisions(){
        return collisions;
    }

    // inutilisé, à supr ?
    public void addCollisions(Pentity pentity){collisions.add(pentity);}

    public void setPositionPoints(int x, int y){
        posY = y;
        posX = x;
    }

    public void print() {
        System.out.println(" type:"+type +
        " posX:"+posX+
        " posY:"+posY+
        " length:"+length+
        " width:"+width+
        " id:"+id+
        " speed:"+speed);
    }
}
