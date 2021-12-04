package Moteurs.physic;

import java.util.ArrayList;

/**
 * Gestion des collisions
 */
public class CollisionManage {


    /**
     * Si deux objets partagent un point (x,y) en commun avec e1 à la position (x,y) donnée
     * Si deux objets se "touchent", ils sont en "contact"
     * @param x Position x
     * @param y Position y
     * @param e1 Entité physique
     * @param e2 Entité physique
     * @return Booléen true si contact
     */
    public static boolean detectContact(double x, double y, PhysicEntity e1, PhysicEntity e2){
        if(x + (e1.getWidth())/2 >= e2.getPosX() - (e2.getWidth())/2 &&
                x - (e1.getWidth())/2 <= e2.getPosX() + (e2.getWidth())/2 &&
                y + (e1.getLength())/2 >= e2.getPosY() - (e2.getLength())/2 &&
                y - (e1.getLength())/2 <= e2.getPosY() + (e2.getLength())/2){
            addCollision(e1,e2);
            return true;
        }
        else {
            deleteCollision(e1,e2);
            return false;
        }
    }



    /**
     * Savoir si quand l'un des deux objets en contact est de type "SOLID"
     * @param x Position x
     * @param y Position y
     * @param e1 Entité physique
     * @param e2 Entité physique
     * @return Booléen
     */
    public static boolean detectCollision(double x, double y, PhysicEntity e1, PhysicEntity e2) {
        if (e1.getType() == e2.getType() && e1.getType() == Type.SOFT) {
            e1.setInCollision(false);
            e2.setInCollision(false);
            return false;
        }
        else {
            if(detectContact(x, y, e1, e2))
                e1.setInCollision(true);
                e2.setInCollision(true);
                return true;

        }

    }

    /**
     * Détecte les collisions avec les autres entités
     * @param e Entité physique
     * @param entitiesAt Liste d'entités
     * @return Booléen
     */
    public static boolean detectCollisionWithEntities(PhysicEntity e, ArrayList<PhysicEntity> entitiesAt) {
        boolean collision = false;
        for (PhysicEntity physicEntity: entitiesAt) {

            if (!(e.getType() == physicEntity.getType() && e.getType() == Type.SOFT)) {
                if(detectCollision(e.getPosX(),e.getPosY(),e,physicEntity)){
                    collision = true;
                    addCollision(e,physicEntity);
                }
            }
            deleteCollision(e,physicEntity);
        }
        e.setInCollision(collision);
        return collision;

    }


    /**
     * Ajoute une collision
     * @param e1 Entité physique
     * @param e2 Entité physique
     */
    public static void addCollision(PhysicEntity e1, PhysicEntity e2){
        e1.getCollisions().add(e2);
        e2.getCollisions().add(e1);
    }

    /**
     * Supprime une collision
     * @param e1 Entité physique
     * @param e2 Entité physique
     */
    public static void deleteCollision(PhysicEntity e1, PhysicEntity e2){
        e1.getCollisions().remove(e2);
        e2.getCollisions().remove(e1);
    }


}
