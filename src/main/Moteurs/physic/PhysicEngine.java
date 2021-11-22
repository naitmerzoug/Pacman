package Moteurs.physic;

import java.util.ArrayList;
import java.util.HashMap;

public class PhysicEngine {



    //On créé un monde constitué d'entité
    private HashMap<Type, ArrayList<PhysicEntity>> world;
    private CollisionManage collisionManage;

    public PhysicEngine() {
        this.world = new HashMap<>();
        this.collisionManage = new CollisionManage();
    }

    public boolean createEntity(int id, Type type, double posX, double posY, double length, double width, int speed){
       if (get(id) != null)
           return false;
        PhysicEntity pentity = new PhysicEntity(id, type, posX,  posY, length,  width,  speed);
        if( ! world.containsKey(type))
            world.put(type, new ArrayList<>());
        return world.get(type).add(pentity);
    }

    public boolean createEntity(Type type,double posX, double posY,double length, double width, int speed){
        int id = getAllWorld().size();
        while (null != get(id))
            id++;
        PhysicEntity pentity = new PhysicEntity(id, type, posX,  posY, length,  width,  speed);
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
    public boolean positionIsReachable(PhysicEntity pentity, DIRECTION direction){
        return null == getObjectCollision(pentity,direction) ;
    }

    /**
     * Retourne l'object avec lequel il y a colision sinon null
     * @param direction
     * @param pentity
     * @return Pentity
     */
    public PhysicEntity getObjectCollision(PhysicEntity pentity, DIRECTION direction){

        //Pour chaque entité de type SOFT on prend uniquement le type SOLID car SOFT && SOFT est forcément traversable!
        if(pentity.getType()==Type.SOFT)
            // Test collison
            for(PhysicEntity pentity1 : world.get(Type.SOLID)) {
                switch (direction){
                    case UP -> {
                        if (!collisionManage.detectCollision(pentity.getPosX(),pentity.getPosY() + 1,  pentity, pentity1))
                            return pentity1;
                    }
                    case DOWN -> {
                        if (!collisionManage.detectCollision(pentity.getPosX(),pentity.getPosY() - 1,  pentity, pentity1))
                            return pentity1;
                    }
                    case LEFT ->{
                        if (!collisionManage.detectCollision(pentity.getPosX() - 1,pentity.getPosY(),  pentity, pentity1))
                            return pentity1;
                    }
                    case RIGHT -> {
                        if (!collisionManage.detectCollision( pentity.getPosX() + 1,pentity.getPosY(), pentity, pentity1))
                            return pentity1;
                    }
                }
            }

        //Pour chaque entité de type SOLID nous sommes obligé de tester le monde complet qu'importe son type
        if(pentity.getType()==Type.SOLID)
            for(PhysicEntity pentity1 : getAllWorld()) {
                switch (direction){
                    case UP -> {
                        if (!collisionManage.detectCollision(pentity.getPosY() + 1, pentity.getPosX(), pentity, pentity1))
                            return pentity1;
                    }
                    case DOWN -> {
                        if (!collisionManage.detectCollision(pentity.getPosY() - 1, pentity.getPosX(), pentity, pentity1))
                            return pentity1;
                    }
                    case LEFT ->{
                        if (!collisionManage.detectCollision(pentity.getPosY(), pentity.getPosX() - 1, pentity, pentity1))
                            return pentity1;
                    }
                    case RIGHT -> {
                        if (!collisionManage.detectCollision(pentity.getPosY(), pentity.getPosX() + 1, pentity, pentity1))
                            return pentity1;
                    }
                }
            }

        return null;

    }

    public ArrayList<PhysicEntity> getAllWorld() {
        ArrayList<PhysicEntity> arrayList = new ArrayList<>();
        for(Type type : world.keySet()) {
            arrayList.addAll(world.get(type));
        }
        return arrayList;
    }

    public void setPosition(PhysicEntity pentity, DIRECTION direction){
        switch (direction){
            case UP    -> pentity.setPositionPoints ((int) pentity.getPosX(),(int) pentity.getPosY() + 1);
            case DOWN  -> pentity.setPositionPoints ((int) pentity.getPosX(),(int) pentity.getPosY() - 1);
            case LEFT  -> pentity.setPositionPoints ((int) pentity.getPosX() - 1,(int) pentity.getPosY());
            case RIGHT -> pentity.setPositionPoints ((int) pentity.getPosX() + 1,(int) pentity.getPosY());
        }
    }

    public PhysicEntity get(int id){
        for(PhysicEntity pentity: getAllWorld())
            if(pentity.getId() == id)
                return pentity;

        return null;
    }

    public boolean remove(int id){
        for(PhysicEntity pentity: getAllWorld())
            if(pentity.getId() == id)
                return world.get(pentity.getType()).remove(pentity);
        return false;
    }

    public boolean add(PhysicEntity pentity) {
        if(null == get(pentity.getId())) {
            if( ! world.containsKey(pentity.getType()))
                world.put(pentity.getType(), new ArrayList<>());
            return world.get(pentity.getType()).add(pentity);
        }
        return false;
    }

    public void printWord(){
        for(PhysicEntity entity : getAllWorld())
            entity.print();
    }

    public double sqr(double a){
        return a*a;
    }

    /**
     * Calcule de la ditance entre deux points d'un referentiel orthonormé
     * @param e1 Entité avec deux coordonées; x,y
     * @param e2 Entité avec deux coordonées; x,y
     * @return La distance entre les deux entitées
     */
    public double distanceBetweenTowPoints(PhysicEntity e1, PhysicEntity e2){
        double part1 = sqr(e2.getPosY()-e1.getPosY());
        double part2 = sqr(e2.getPosX()-e1.getPosX());
        return Math.sqrt(part1+part2);

    }




}
