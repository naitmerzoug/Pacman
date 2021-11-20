package Moteurs.physic;

public class CollisionManage {

    /**
     * Si deux objets partagent un point (x,y) en commun
     * Si deux objets se "touchent", son en "contact"
     * @param e1
     * @param e2
     * @return
     */
    public static boolean detectContact(Pentity e1, Pentity e2){
        return e1.getPosX() + (e1.getWidth())/2 >= e2.getPosX() - (e2.getWidth())/2 &&
                e1.getPosX() - (e1.getWidth())/2 <= e2.getPosX() + (e2.getWidth())/2 &&
                e1.getPosY() + (e1.getLength())/2 >= e2.getPosY() - (e2.getLength())/2 &&
                e1.getPosY() - (e1.getLength())/2 <= e2.getPosY() + (e2.getLength())/2 ;
    }

    /**
     * Si deux objets partagent un point (x,y) en commun avec e1 à la position (x,y) donnée
     * Si deux objets se "touchent", son en "contact"
     * @param x
     * @param y
     * @param e1
     * @param e2
     * @return
     */
    public static boolean detectContact(double x, double y, Pentity e1, Pentity e2){
        return x + (e1.getWidth())/2 >= e2.getPosX() - (e2.getWidth())/2 &&
                x - (e1.getWidth())/2 <= e2.getPosX() + (e2.getWidth())/2 &&
                y + (e1.getLength())/2 >= e2.getPosY() - (e2.getLength())/2 &&
                y - (e1.getLength())/2 <= e2.getPosY() + (e2.getLength())/2 ;
    }

    /**
     * Deux objets sont en contact et l'un d'eux est de type "SOLID"
     * @param x
     * @param y
     * @param e1
     * @param e2
     * @return
     */
    public static boolean detectCollision(double x, double y, Pentity e1, Pentity e2){
        if(e1.getType() == e2.getType() &&  e1.getType() == Type.SOFT)
            return false;
        return ( detectContact( x, y, e1, e2));
    }
}
