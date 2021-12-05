package Moteurs.physic;

import java.awt.geom.Rectangle2D;
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

    /**
     * Nombre d'entités pour l'incrémentation de l'id
     */
    public static int nbEntities = 0;


    public PhysicEngine(){
        entities = new ConcurrentHashMap<>();
    }

    /**
     * Donner un id à l'entitée si elle n'en a pas et l'ajoute à la liste d'entités
      * @param e Entité physique.
     */
    public void addEntity(PhysicEntity e){
        if(e.getId()==0 || entities.containsKey(e.getId())){
            nbEntities++;
            e.setId(nbEntities);
        }
        entities.put(e.getId(),e);
    }

    /**
     * Supprime l'entité de la liste des entités
     * @param e Entité physique.
     */
    public void removeEntity(PhysicEntity e){
        entities.remove(e.getId());
    }


    /**
     * Permet de savoir s'il y a une collision avec un autre objet physique
     * @param x Prochaine position en x
     * @param y Prochaine position en y
     * @param width Largeur
     * @param length Hauteur
     * @return S'il y a collision
     */
    public boolean IsCollision(int id, double x, double y, double width, double length) {
        for (PhysicEntity entity : entities.values()) {
            if (entity.getId() != id) { // si ce n'est pas le perso principal

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
     * Déplace une entité dans une direction
     * @param e Entité physique.
     * @param direction Direction de l'entité
     */
    public void move(PhysicEntity e, DIRECTION direction)
    {
        switch (direction)
        {
            case UP -> {
                // verifie j'ai une collision
                if (IsCollision(e.getId(),e.getPosX(), e.getPosY()+e.getSpeed(), e.getWidth(),e.getLength())){
                    e.setInCollision(true);
                }
                else
                {
                    // si ce n'est pas le cas, je monte
                    e.setInCollision(false);
                    e.setPosY(e.getPosY() + e.getSpeed());
                }
            }
            case DOWN -> {
                if (IsCollision(e.getId(),e.getPosX(), e.getPosY()-e.getSpeed(), e.getWidth(),e.getLength())){
                    e.setInCollision(true);
                }
                else
                {
                    e.setInCollision(false);
                    e.setPosY(e.getPosY() - e.getSpeed());
                }
            }
            case RIGHT -> {
                if (IsCollision(e.getId(),e.getPosX()+e.getSpeed(), e.getPosY(), e.getWidth(),e.getLength())){
                    e.setInCollision(true);
                }
                else
                {
                    e.setInCollision(false);
                    e.setPosX(e.getPosX() + e.getSpeed());
                }
            }
            case LEFT -> {
                if (IsCollision(e.getId(),e.getPosX()-e.getSpeed(), e.getPosY(), e.getWidth(),e.getLength())){
                    e.setInCollision(true);
                }
                else
                {
                    e.setInCollision(false);
                    e.setPosX(e.getPosX() - e.getSpeed());
                }
            }

        }

    }


    // Getters

    public ConcurrentMap<Integer, PhysicEntity> getEntities() {
        return entities;
    }

}
