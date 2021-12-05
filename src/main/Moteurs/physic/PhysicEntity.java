package Moteurs.physic;

import Moteurs.core.CoreEntity;


/**
 * Entité physique
 */
public class PhysicEntity extends CoreEntity {

    private  boolean inCollision;
    private int id;
    private double posX;
    private double posY;
    private double length;
    private double width;
    private double speed;
    private Type type;
    private DIRECTION direction;


    /**
     *
     * @param id Identifiant unique
     * @param type Type (mou ou solide)
     * @param posX Position en x
     * @param posY Position en y
     * @param length Longueur
     * @param width Largeur
     * @param speed Vitesse
     */
    public PhysicEntity(int id, Type type, double posX, double posY, double length, double width, double speed){
        this.type = type;
        this.direction = DIRECTION.NULL;
        this.posX = posX;
        this.posY = posY;
        this.length = length;
        this.width = width;
        this.id= id;
        this.speed = speed;
    }

    /**
     *
     * @param type Type (mou ou solide)
     * @param posX Position en x
     * @param posY Position en y
     * @param length Longueur
     * @param width Largeur
     * @param speed Vitesse
     */
    public PhysicEntity(Type type, double posX, double posY, double length, double width, double speed){
        this.type = type;
        this.direction =DIRECTION.NULL;
        this.posX = posX;
        this.posY = posY;
        this.length = length;
        this.width = width;
        this.speed = speed;
    }


    public int getId() {
        return id;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }


    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getSpeed() {
        return speed;
    }

    public Type getType() {
        return type;
    }

    public DIRECTION getDirection() {
        return direction;
    }


    public boolean isInCollision() {
        return inCollision;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }


    public void setType(Type type) {
        this.type = type;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    public void setInCollision(boolean inCollision) {
        this.inCollision = inCollision;
    }


}
