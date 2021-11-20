package Moteurs.physic;

import java.util.ArrayList;
import java.util.HashMap;

public class Physic {

    //On créé un monde constitué d'entité
    private HashMap<Type, ArrayList<Pentity>> world= new HashMap<>();

    public boolean createEntity(int id,Type type,double posX, double posY,double length, double width, int speed){
       if (get(id) != null)
           return false;
        Pentity pentity = new Pentity(id, type, posX,  posY, length,  width,  speed);
        if( ! world.containsKey(type))
            world.put(type, new ArrayList<>());
        return world.get(type).add(pentity);
    }

    public boolean createEntity(Type type,double posX, double posY,double length, double width, int speed){
        int id = getAllWorld().size();
        while (null != get(id))
            id++;
        Pentity pentity = new Pentity(id, type, posX,  posY, length,  width,  speed);
        if( ! world.containsKey(type))
            world.put(type, new ArrayList<>());
        return world.get(type).add(pentity);
    }

    /**
     * Test si la position est atteignable
     * @param direction
     * @param pentity
     * @return boolean
     */
    public boolean positionIsReachable(Pentity pentity,DIRECTION direction){
        return null == getObjectCollision(pentity,direction) ;
    }

    /**
     * Retourne l'object avec lequel il y a colision sinon null
     * @param direction
     * @param pentity
     * @return Pentity
     */
    public Pentity getObjectCollision(Pentity pentity,DIRECTION direction){

        //Pour chaque entité de type SOFT on prend uniquement le type SOLID car SOFT && SOFT est forcément traversable!
        if(pentity.getType()==Type.SOFT)
            // Test collison
            for(Pentity pentity1 : world.get(Type.SOLID)) {
                switch (direction){
                    case UP -> {
                        if (!CollisionManage.detectCollision(pentity.getPosY() + 1, pentity.getPosX(), pentity, pentity1))
                            return pentity1;
                    }
                    case DOWN -> {
                        if (!CollisionManage.detectCollision(pentity.getPosY() - 1, pentity.getPosX(), pentity, pentity1))
                            return pentity1;
                    }
                    case LEFT ->{
                        if (!CollisionManage.detectCollision(pentity.getPosY(), pentity.getPosX() - 1, pentity, pentity1))
                            return pentity1;
                    }
                    case RIGHT -> {
                        if (!CollisionManage.detectCollision(pentity.getPosY(), pentity.getPosX() + 1, pentity, pentity1))
                            return pentity1;
                    }
                }
            }

        //Pour chaque entité de type SOLID nous sommes obligé de tester le monde complet qu'importe son type
        if(pentity.getType()==Type.SOLID)
            for(Pentity pentity1 : getAllWorld()) {
                switch (direction){
                    case UP -> {
                        if (!CollisionManage.detectCollision(pentity.getPosY() + 1, pentity.getPosX(), pentity, pentity1))
                            return pentity1;
                    }
                    case DOWN -> {
                        if (!CollisionManage.detectCollision(pentity.getPosY() - 1, pentity.getPosX(), pentity, pentity1))
                            return pentity1;
                    }
                    case LEFT ->{
                        if (!CollisionManage.detectCollision(pentity.getPosY(), pentity.getPosX() - 1, pentity, pentity1))
                            return pentity1;
                    }
                    case RIGHT -> {
                        if (!CollisionManage.detectCollision(pentity.getPosY(), pentity.getPosX() + 1, pentity, pentity1))
                            return pentity1;
                    }
                }
            }

        return null;

    }

    public ArrayList<Pentity> getAllWorld() {
        ArrayList<Pentity> arrayList = new ArrayList<>();
        for(Type type : world.keySet()) {
            arrayList.addAll(world.get(type));
        }
        return arrayList;
    }

    /**
     * Fixe la position d'un objet en fonction de sa direction
     * @param direction
     * @param pentity
     */
    public void setPosition(Pentity pentity,DIRECTION direction){
        switch (direction){
            case UP    -> pentity.setPositionPoints ((int) pentity.getPosY() + 1, (int) pentity.getPosX());
            case DOWN  -> pentity.setPositionPoints ((int) pentity.getPosY() - 1, (int) pentity.getPosX());
            case LEFT  -> pentity.setPositionPoints ((int) pentity.getPosY(), (int) pentity.getPosX() - 1);
            case RIGHT -> pentity.setPositionPoints ((int) pentity.getPosY(), (int) pentity.getPosX() + 1);
        }
    }

    public Pentity get(int id){
        for(Pentity pentity: getAllWorld())
            if(pentity.getId() == id)
                return pentity;

        return null;
    }

    public boolean remove(int id){
        for(Pentity pentity: getAllWorld())
            if(pentity.getId() == id)
                return world.get(pentity.getType()).remove(pentity);
        return false;
    }

    public boolean add(Pentity pentity) {
        if(null == get(pentity.getId())) {
            if( ! world.containsKey(pentity.getType()))
                world.put(pentity.getType(), new ArrayList<>());
            return world.get(pentity.getType()).add(pentity);
        }
        return false;
    }

    public void printWord(){
        for(Pentity entity : getAllWorld())
            entity.print();
    }
}
