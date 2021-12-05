package Moteurs.physic;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Moteur physique
 */
public class PhysicEngine {

    /**
     * Liste d'entités
     */
    private ConcurrentMap<Integer,PhysicEntity> entities;

    private final CollisionManage collisionManage;

    /**
     * Nombre d'entités
     */
    public static int nbEntities = 0;


    public PhysicEngine(){
        entities = new ConcurrentHashMap<>();
        collisionManage = new CollisionManage();
    }

    /**
     * Donner un id à l'entitée si elle n'en a pas et l'ajoute à la liste d'entités;
      * @param e Entité physique.
     */
    public void createEntity(PhysicEntity e){
        if(e.getId()==0 || entities.containsKey(e.getId())){
            nbEntities++;
            e.setId(nbEntities);
        }
        entities.put(e.getId(),e);
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
     * Permet de savoir si une entité à pris cette direction.
      * @param physicEntity Entité physique.
     * @param direction direction de l'Entité physique.
     * @return True s'il y a une entité, sinon False.
     */
    public boolean CheckDirection(PhysicEntity physicEntity, DIRECTION direction){
        switch (direction){
            case UP:
                return entitiesAtPosition(physicEntity.getPosX(), physicEntity.getPosY() + 1,
                        physicEntity.getLength(), physicEntity.getWidth()).size() != 0;

            case DOWN:
                return entitiesAtPosition(physicEntity.getPosX(), physicEntity.getPosY() - 1,
                        physicEntity.getLength(), physicEntity.getWidth()).size() != 0;


            case RIGHT:
                return entitiesAtPosition(physicEntity.getPosX() + 1, physicEntity.getPosY() + 1,
                        physicEntity.getLength(), physicEntity.getWidth()).size() != 0;


            case LEFT:
                return entitiesAtPosition(physicEntity.getPosX() - 1, physicEntity.getPosY(),
                        physicEntity.getLength(), physicEntity.getWidth()).size() != 0;


            case NULL:
                return entitiesAtPosition(physicEntity.getPosX(), physicEntity.getPosY(),
                        physicEntity.getLength(), physicEntity.getWidth()).size() != 0;


            default:
                return true;
        }
    }

    /**
     * Retourne les entités à une position
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
     * Retourne les entités dans un périmètre
     * @param x position x
     * @param y position y
     * @param length hauteur
     * @param width largeur
     * @return  Liste des entitées se trouvant dans le perimetre ayant comme centre x,y.
     */
    public ArrayList<PhysicEntity> entitiesAtPosition(double x, double y, double length, double width) {
        ArrayList<PhysicEntity> entitiesAt = new ArrayList<>();
        for (PhysicEntity entity : entities.values()) {
            if (x + width > entity.getPosX() && y + length > entity.getPosY()
                    && x < entity.getPosX() + entity.getWidth()
                    && y < entity.getPosY() + entity.getLength()) {
                if (entity.getId() != 1)
                    entitiesAt.add(entity);
            }
        }
        return entitiesAt;
    }

    /**
     * Déplace une entité dans une position;
     * @param e Entité physique.
     * @param stepX Pas en fonction de x
     * @param stepY Pas en fonction de y
     */
    public void moving(PhysicEntity e, double stepX, double stepY){
        for (int i = 0; i < e.getSpeed() && !e.isInCollision() ; i++){
            e.setOldX(e.getPosX());
            e.setOldY(e.getPosY());
            e.setPosX(e.getPosX() + stepX);
            e.setPosY(e.getPosY() + stepY);

            if(CollisionManage.detectCollisionWithEntities(e,entitiesAtPosition(e.getPosX(),e.getPosY(),e.getLength(),e.getWidth()))){

                e.setPosX(e.getOldX());
                e.setPosY(e.getOldY());
            }

        }
    }

    /**
     * Permet de savoir s'il y a une collision avec un autre objet physique
     * @param x Prochaine position en x
     * @param y Prochaine position en y
     * @param width Largeur
     * @param length Hauteur
     * @return S'il y a collision
     */
    public boolean IsCollision(double x, double y, double width, double length) {
        for (PhysicEntity entity : entities.values()) {
            if (entity.getId() != 1) { // si ce n'est pas le perso principal

                Rectangle2D r = new Rectangle2D.Double(x, y, width, length);
                Rectangle2D p = new Rectangle2D.Double(entity.getPosX(), entity.getPosY(), entity.getWidth(), entity.getLength());
                if (r.intersects(p)) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * Déplace une entité dans une direction;
     * @param e Entité physique.
     * @param direction Direction de l'entitée.
     */
    public void move(PhysicEntity e, DIRECTION direction)
    {
        switch (direction)
        {
            case UP -> {
                // verifie si en montant je n'ai pas de collision
                if (IsCollision(e.getPosX(), e.getPosY()+e.getSpeed(), e.getWidth(),e.getLength())){
                   break;
                 }
                else
                {
                    // si ce n'est pas le cas, je monte
                    e.setPosY(e.getPosY() + e.getSpeed());
                }
            }
            case DOWN -> {
                if (IsCollision(e.getPosX(), e.getPosY()-e.getSpeed(), e.getWidth(),e.getLength())){
                    break;
                }
                else
                {
                    e.setPosY(e.getPosY() - e.getSpeed());
                }
            }
            case RIGHT -> {
                if (IsCollision(e.getPosX()+e.getSpeed(), e.getPosY(), e.getWidth(),e.getLength())){
                    break;
                }
                else
                {
                    e.setPosX(e.getPosX() + e.getSpeed());
                }
            }
            case LEFT -> {
                if (IsCollision(e.getPosX()-e.getSpeed(), e.getPosY(), e.getWidth(),e.getLength())){
                    break;
                }
                else
                {
                    e.setPosX(e.getPosX() - e.getSpeed());
                }
            }



        }
        /*
        if (!IsCollision(e)) {
            switch (direction) {
                case UP -> e.setPosY(e.getPosY() + e.getSpeed());
                case DOWN -> e.setPosY(e.getPosY() - e.getSpeed());
                case RIGHT -> e.setPosX(e.getPosX() + e.getSpeed());
                case LEFT -> e.setPosX(e.getPosX() - e.getSpeed());
            }
        }

         */

    }
    /*
    public void move(PhysicEntity e, DIRECTION direction){
        switch (direction){
            case UP :
                e.setDirection(direction);
                e.setStepX(0);
                e.setStepY(1);
                moving(e,e.getStepX(),e.getStepY());
                break;

            case DOWN :
                e.setDirection(direction);
                e.setStepX(0);
                e.setStepY(-1);
                moving(e,e.getStepX(),e.getStepY());
                break;

            case RIGHT:
                e.setDirection(direction);
                e.setStepX(1);
                e.setStepY(0);
                moving(e,e.getStepX(),e.getStepY());
                break;

            case LEFT:
                e.setDirection(direction);
                e.setStepX(-1);
                e.setStepY(0);
                moving(e,e.getStepX(),e.getStepY());
                break;

            case NULL: e.setDirection(direction);
        }
    }
    */
    /**
     * Calcule de le carré d'un nombre
     * @param a Nombre
     * @return Carré de ce nombre
     */
    public static double sqr(double a){
        return a*a;
    }

    /**
     * Calcule de la distance entre deux points d'un réferentiel orthonormé
     * @param e1 Entité avec deux coordonées; x,y
     * @param e2 Entité avec deux coordonées; x,y
     * @return La distance entre les deux entitées
     */
    public double distanceBetweenTowPoints(PhysicEntity e1, PhysicEntity e2){
        double part1 = sqr(e2.getPosY()-e1.getPosY());
        double part2 = sqr(e2.getPosX()-e1.getPosX());
        return Math.sqrt(part1+part2);

    }

    // Getters

    public ConcurrentMap<Integer, PhysicEntity> getEntities() {
        return entities;
    }

    public CollisionManage getCollisionManage() {
        return collisionManage;
    }

    public static int getNbEntities() {
        return nbEntities;
    }

    // Setters

    public void setEntities(ConcurrentMap<Integer, PhysicEntity> entities) {
        this.entities = entities;
    }

    public static void setNbEntities(int nbEntities) {
        PhysicEngine.nbEntities = nbEntities;
    }
}
