package Moteurs.physic;

import java.util.ArrayList;
import java.util.HashMap;

public class Physic {

    //On créé un monde constitué d'entité
    private HashMap<Type, Pentity> world= new HashMap<>();

    public void createEntity(int id,Type type,double posX, double posY,double length, double width, int speed){
        Pentity pentity = new Pentity(id, type, posX,  posY, length,  width,  speed);
        world.put(type, pentity);
    }

    public boolean moove(DIRECTION direction, Pentity pentity){
        //isNotSolid


        if( ! pentity.checkPositionIsValide(entities))
            return false;
        pentity.setPosition();
        return true;
    }



}
