package Moteurs.physic;

public class CollisionManage {





    public static void detectCollision(Entity e1, Entity e2){
        boolean thereIsACollision ;
        if(e1.getPosX() + (e1.getWidth())/2 >= e2.getPosX() - (e2.getWidth())/2 &&
                e1.getPosX() - (e1.getWidth())/2 <= e2.getPosX() + (e2.getWidth())/2 &&
                e1.getPosY() + (e1.getLength())/2 >= e2.getPosY() - (e2.getLength())/2 &&
                e1.getPosY() - (e1.getLength())/2 <= e2.getPosY() + (e2.getLength())/2){
               thereIsACollision= true;
            System.out.println(thereIsACollision);
        }
        else {
            thereIsACollision =false;
            System.out.println(thereIsACollision);
        }

    }
}
