package Moteurs.physic;

import java.util.ArrayList;
import java.util.HashMap;

public class Physic {

    //On créé un monde constitué d'entité
    private HashMap<Type, Pentity> world= new ArrayList<>();

    public void createEntity(int id,Type type,double posX, double posY,double length, double width, int speed){
        Pentity pentity = new Pentity(id, type, posX,  posY, length,  width,  speed);
        if(world.containsKey(type))
    }



/* up (){
    entité.move()
}
*/

    public boolean moove(DIRECTION direction, Pentity pentity, ArrayList<Pentity> entities){
        if( ! pentity.checkPositionIsValide(entities))
            return false;
        pentity.setPosition();
        return true;
    }



}
