package Moteurs;
import Moteurs.physic.*;
public class Main {




    public static void main(String[] args) {
        Entity mur = new Entity(2,2,2,2);
        Entity pac = new Entity(3,3,2,2);

        CollisionManage.detectCollision(mur,pac);


    }




}
