package Moteurs.physic;

import java.util.ArrayList;
import java.util.HashMap;

import static Moteurs.physic.CollisionManage.*;

public class Physic {

    //On créé un monde constitué d'entité
    private HashMap<Type, Entity> world= new ArrayList<>();

    public void createEntity(int id,Type type,double posX, double posY,double length, double width, int speed){
        Entity entity = new Entity(id, type, posX,  posY, length,  width,  speed);
        if(world.containsKey(type))
    }



/* up (){
    entité.move()
}
*/

    public boolean moove(DIRECTION direction, Entity entity, ArrayList<Entity> entities){
        if( ! entity.checkPositionIsValide(entities))
            return false;
        entity.setPosition();
        return true;
    }

}
