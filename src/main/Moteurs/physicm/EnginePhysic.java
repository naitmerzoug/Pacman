package Moteurs.physicm;

import java.util.ArrayList;

public class EnginePhysic {

    private ArrayList<EntityPhysic> entities;

    public EnginePhysic(){
        entities = new ArrayList<EntityPhysic>();
    }

    public EntityPhysic createAndAddEntity(int id, double x, double y, double width, double height, Type type, double speed){
        EntityPhysic entityPhysic = new EntityPhysic(id,x,y,width,height,type, speed);
        entities.add(entityPhysic);
        return entityPhysic;
    }

    // TODO: 03/12/2021
    // à tester
    /**
     * Cherche à déterminer la liste de collision de l'entité dans le cas où il se dépalcerait aux coordonnées x,y
     * @param entityPhysic entité qui souahite se déplacer
     * @param nextX La coordonnée de son prochain centre de l'objet
     * @param nextY La coordonnée de son prochain centre l'objet
     * @return Liste de collisions
     */
    public ArrayList<EntityPhysic> getCollisionsList(EntityPhysic entityPhysic, double nextX , double nextY){

        entityPhysic.resetCollisionList();

        for(EntityPhysic entityPhysic1 : entities){
            if(CollisionPhysic.isCollision(entityPhysic1, entityPhysic,  nextX,  nextY) && entityPhysic!=entityPhysic1)
                entityPhysic.addCollisionList(entityPhysic1);
        }
        return entityPhysic.getCollisionList();
    }

    public void setEntities(ArrayList<EntityPhysic> entities) {
        this.entities = entities;
    }

    public static void move(EntityPhysic entityPhysic, double step)
    {
        switch(entityPhysic.getDirection()){
            case UP -> entityPhysic.setY(entityPhysic.getY() + entityPhysic.getSpeed() * step);
            case DOWN -> entityPhysic.setY(entityPhysic.getY() - entityPhysic.getSpeed() * step);
            case LEFT -> entityPhysic.setX(entityPhysic.getX() - entityPhysic.getSpeed() * step);
            case RIGHT -> entityPhysic.setX(entityPhysic.getX() + entityPhysic.getSpeed() * step);
        }
    }

    public void removeEntity(EntityPhysic entityPhysic)
    {
        entities.remove(entityPhysic);
    }

}
