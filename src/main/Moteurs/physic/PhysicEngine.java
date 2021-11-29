package Moteurs.physic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PhysicEngine {


    private ConcurrentMap<Integer,PhysicEntity> entities;

    private final CollisionManage collisionManage;

    public static int nbEntities = 0;



    public PhysicEngine(){
        entities = new ConcurrentHashMap<>();
        collisionManage = new CollisionManage();
    }


    /**
     * Donner un id à l'entitée si elle n'en a pas et l'ajouter à entities;
      * @param e Entité physique.
     */
    public void createEntity(PhysicEntity e){
        if(e.getId()==0 || entities.containsKey(e.getId())){
            nbEntities++;
            e.setId(nbEntities);
            entities.put(e.getId(),e);
        }
    }

    /**
     * Supprime l'entité des listes de collision de chauque entitée et la supprime de entities.
     * @param e Entité physique.
     */
    public void removeEntity(PhysicEntity e){
        for(PhysicEntity e1 : entities.values()){
            e1.getCollisions().remove(e);
        }
        entities.remove(e.getId());
    }


    /**
     * Permet de savoir si'il ya une entitée à un un pas dépendant de la direction.
      * @param physicEntity Entité physique.
     * @param direction direction de l'Entité physique.
     * @return True si il y'a bien une entitée, false sinon.
     */
    public boolean isSomething(PhysicEntity physicEntity, DIRECTION direction){
        switch (direction){
            case UP -> {
                return entitiesAtPosition(physicEntity.getPosX(), physicEntity.getPosY() + 1,
                        physicEntity.getLength(), physicEntity.getWidth()).size() != 0;
            }
            case DOWN -> {
                return entitiesAtPosition(physicEntity.getPosX(), physicEntity.getPosY() - 1,
                        physicEntity.getLength(), physicEntity.getWidth()).size() != 0;

            }
            case RIGHT -> {
                return entitiesAtPosition(physicEntity.getPosX() + 1, physicEntity.getPosY() + 1,
                        physicEntity.getLength(), physicEntity.getWidth()).size() != 0;

            }
            case LEFT -> {
                return entitiesAtPosition(physicEntity.getPosX() - 1, physicEntity.getPosY(),
                        physicEntity.getLength(), physicEntity.getWidth()).size() != 0;

            }
            case NULL -> {
                return entitiesAtPosition(physicEntity.getPosX(), physicEntity.getPosY(),
                        physicEntity.getLength(), physicEntity.getWidth()).size() != 0;

            }
            default -> {
                return true;
            }
        }
    }

    /**
     *
     * @param x position x
     * @param y position y
     * @return Liste des entitées ayant comme cooordonées : x et y
     */

    public ArrayList<PhysicEntity> entitiesAtPosition(double x, double y){
        ArrayList<PhysicEntity> entitiesAt = new ArrayList<>();
        for (PhysicEntity entity : entities.values()){
            if(entity.getPosX()==x && entity.getPosY()==y){
                entitiesAt.add(entity);
            }
        }
        return entitiesAt;

    }

    /**
     *
     * @param x position x
     * @param y position y
     * @param length hauteur
     * @param width largeur
     * @return  Liste des entitées ayant comme cooordonées : se trouvant dans le perimetre ayant comme centre x,y et une hauteur ainsi qu'une largeur.
     */
    public ArrayList<PhysicEntity> entitiesAtPosition(double x, double y, double length, double width) {
        ArrayList<PhysicEntity> entitiesAt = new ArrayList<>();
        for (PhysicEntity entity : entities.values()) {
            if (x + width > entity.getPosX() && y + length > entity.getPosY()
                    && x < entity.getPosX() + entity.getWidth()
                    && y < entity.getPosY() + entity.getLength())
                entitiesAt.add(entity);
        }
        return entitiesAt;
    }


    public void moving(PhysicEntity e, double stepX, double stepY){
        for (int i = 0; i < e.getSpeed();i++){
            e.setOldX(e.getPosX());
            e.setOldY(e.getPosY());
            e.setPosX(e.getPosX() + stepX);
            e.setPosY(e.getPosY() + stepY);
        }
    }

    /**
     * Deplacer une entité dans une direction;
     * @param e Entité physique.
     * @param direction Direction de l'entitée.
     */
    public void move(PhysicEntity e, DIRECTION direction){
        switch (direction){
            case UP -> {
                e.setDirection(direction);
                e.setStepX(0);
                e.setStepY(1);
                moving(e,e.getStepX(),e.getStepY());
            }
            case DOWN -> {
                e.setDirection(direction);
                e.setStepX(0);
                e.setStepY(-1);
                moving(e,e.getStepX(),e.getStepY());
            }
            case RIGHT -> {
                e.setDirection(direction);
                e.setStepX(1);
                e.setStepY(0);
                moving(e,e.getStepX(),e.getStepY());
            }
            case LEFT -> {
                e.setDirection(direction);
                e.setStepX(-1);
                e.setStepY(0);
                moving(e,e.getStepX(),e.getStepY());
            }
            case NULL -> e.setDirection(direction);
        }
    }

    public static double sqr(double a){
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


    public ConcurrentMap<Integer, PhysicEntity> getEntities() {
        return entities;
    }

    public CollisionManage getCollisionManage() {
        return collisionManage;
    }

    public void setEntities(ConcurrentMap<Integer, PhysicEntity> entities) {
        this.entities = entities;
    }

    public static void setNbEntities(int nbEntities) {
        PhysicEngine.nbEntities = nbEntities;
    }
}
