package Moteurs.physic;

import Moteurs.core.CoreEntity;

import java.util.HashSet;
import java.util.Set;

public class PhysicEntity extends CoreEntity {

    private  boolean inCollision;
    private int id;
    private double posX;
    private double posY;
    private double oldX;
    private double oldY;
    private double length;
    private double width;
    private double speed;
    private Type type;
    private DIRECTION direction;
    private Set<PhysicEntity> collisions;
    private double stepX;
    private double stepY;

    /**
     *
     * @param id int
     * @param type Type
     * @param posX double
     * @param posY double
     * @param length double
     * @param width double
     * @param speed double
     */
    public PhysicEntity(int id, Type type, double posX, double posY, double length, double width, double speed){
        this.type = type;
        this.direction = DIRECTION.NULL;
        this.posX = posX;
        this.posY = posY;
        this.oldX = 0;
        this.oldY = 0;
        this.length = length;
        this.width = width;
        this.id= id;
        this.speed = speed;
        this.collisions = new HashSet<>();
    }
    public PhysicEntity(Type type, double posX, double posY, double length, double width, double speed){
        this.type = type;
        this.direction =DIRECTION.NULL;
        this.posX = posX;
        this.posY = posY;
        this.oldX = 0;
        this.oldY = 0;
        this.length = length;
        this.width = width;
        this.speed = speed;
        this.collisions = new HashSet<>();
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

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
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

    public Set<PhysicEntity> getCollisions() {
        return collisions;
    }

    public double getStepX(){
        return stepX;
    }
    public double getStepY(){
        return stepY;
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

    public void setOldX(double oldX) {
        this.oldX = oldX;
    }

    public void setOldY(double oldY) {
        this.oldY = oldY;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    public void setCollisions(Set<PhysicEntity> collisions) {
        this.collisions = collisions;
    }

    public void setStepX(double stepX) {
        this.stepX = stepX;
    }

    public void setStepY(double stepY) {
        this.stepY = stepY;
    }

    public void setInCollision(boolean inCollision) {
        this.inCollision = inCollision;
    }

    @Override
    public String toString() {
        return "PhysicEntity{" +
                "id=" + id +
                ", posX=" + posX +
                ", posY=" + posY +
                ", oldX=" + oldX +
                ", oldY=" + oldY +
                ", length=" + length +
                ", width=" + width +
                ", speed=" + speed +
                ", type=" + type +
                ", collisions=" + collisions +
                '}';
    }


}
