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
    public ArrayList<EntityPhysic> getCollisionsList(EntityPhysic entityPhysic, double nextX , double nextY){
        for(EntityPhysic entityPhysic1 : entities){
            if(CollisionPhysic.isCollision(entityPhysic1, entityPhysic,  nextX,  nextY) && entityPhysic!=entityPhysic1)
                entityPhysic.addCollisionList(entityPhysic1);
        }
    }


}
