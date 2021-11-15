package Moteurs.physic;

public class CollisionManage {





    public CollisionManage() {
    }

    public static boolean detectCollision(Pentity e1, Pentity e2){
        return e1.getPosX() + (e1.getWidth())/2 >= e2.getPosX() - (e2.getWidth())/2 &&
                e1.getPosX() - (e1.getWidth())/2 <= e2.getPosX() + (e2.getWidth())/2 &&
                e1.getPosY() + (e1.getLength())/2 >= e2.getPosY() - (e2.getLength())/2 &&
                e1.getPosY() - (e1.getLength())/2 <= e2.getPosY() + (e2.getLength())/2 ;
        }


    public void addCollisions(){

    }


    public void removeCollisions(){

    }
}
