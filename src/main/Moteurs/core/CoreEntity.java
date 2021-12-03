package Moteurs.core;

import Moteurs.physic.PhysicEntity;
import Moteurs.physic.Type;
import Moteurs.physicm.EntityPhysic;

import javax.swing.*;

public class CoreEntity {

    private int id = 0;
    private EntityPhysic physicEntity;
    private JPanel graphicEntity;

   // public CoreEntity(PhysicEntity physicEntity, JLabel graphicEntity){
   //     this.physicEntity = physicEntity;
   //     this.graphicEntity = graphicEntity;
   // }



    // Getters

    public EntityPhysic getEntityPhysic() {
        return physicEntity;
    }

    public JPanel getGraphicEntity() { return graphicEntity; }

    public int getId() { return id; }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setEntityPhysic(EntityPhysic physicEntity) {
        this.physicEntity = physicEntity;
    }

    public void setGraphicEntity(JPanel graphicEntity) {
        this.graphicEntity = graphicEntity;
    }
}
