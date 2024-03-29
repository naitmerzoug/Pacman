package Moteurs.physicm;

public class CollisionPhysic {

    // TODO: 03/12/2021  
    /**
     * Si deux entités se touchent
     * @param entityPhysic1
     * @param entityPhysic2
     * @return
     */
    public static boolean isContact(EntityPhysic e1, EntityPhysic e2, double nextX, double nextY) {
        return (nextX + e1.getX() + (e1.getWidth()) / 2 >= e2.getX() - (e2.getWidth()) / 2 &&
                nextX - e1.getX() - (e1.getWidth()) / 2 <= e2.getX() + (e2.getWidth()) / 2 &&
                nextY + e1.getY() + (e1.getHeight()) / 2 >= e2.getY() - (e2.getHeight()) / 2 &&
                nextY - e1.getY() - (e1.getHeight()) / 2 <= e2.getY() + (e2.getHeight()) / 2);
    }

    // TODO: 03/12/2021  
    /**
     * Si le fait d'être en contact créé une collision
     * @param entityPhysic1
     * @param entityPhysic2
     * @return
     */
    public static boolean isCollision(EntityPhysic entityPhysic1, EntityPhysic entityPhysic2, double x, double y){
        if(!(entityPhysic1.getType() == entityPhysic2.getType() && entityPhysic2.getType()==Type.SOFT))
        {
            return isContact(entityPhysic1, entityPhysic2, x, y);
        }
        else
        {
            return false;
        }
    }

}
