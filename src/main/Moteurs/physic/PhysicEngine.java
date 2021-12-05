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
     * Nombre d'entités
     */
    public static int nbEntities = 0;


    public PhysicEngine(){
        entities = new ConcurrentHashMap<>();
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


    // Getters

    public ConcurrentMap<Integer, PhysicEntity> getEntities() {
        return entities;
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
