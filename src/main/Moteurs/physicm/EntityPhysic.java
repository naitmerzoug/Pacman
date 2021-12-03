package Moteurs.physicm;

import java.util.ArrayList;

public class EntityPhysic {
    int id;
    double x;
    double y;
    double width;
    double height;
    Type type;
    double speed;

    DIRECTION direction;

    ArrayList<EntityPhysic> collisionList;


    public EntityPhysic(int id, double x, double y, double width, double height, Type type, double speed) {
        this.id = id;
        this.direction = DIRECTION.NOTHING;
        this.height = height;
        this.x = x;
        this.y = y;
        this.width = width;
        this.type = type;
        this.speed = speed;
        this.collisionList = new ArrayList<>();
    }

    public void setPosition(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setDirection(DIRECTION newDirection){
        direction = newDirection;
    }

    public ArrayList<EntityPhysic> getCollisionList(){
        return getCollisionList();
    }

    public void addCollisionList(EntityPhysic entityPhysic){
        collisionList.add(entityPhysic);
    }

    public void resetCollisionList(){
        collisionList = new ArrayList<>();
    }

    public Type getType() {
        return type;
    }
}
