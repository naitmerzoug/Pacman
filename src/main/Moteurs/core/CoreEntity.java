package Moteurs.core;

import Moteurs.physic.PhysicEntity;
import Moteurs.physic.Type;

import javax.swing.*;

public class CoreEntity {

    private int id = 0;
    private PhysicEntity physicEntity;
    private JLabel graphicEntity;

   // public CoreEntity(PhysicEntity physicEntity, JLabel graphicEntity){
   //     this.physicEntity = physicEntity;
   //     this.graphicEntity = graphicEntity;
   // }



    // Getters

    public PhysicEntity getPhysicEntity() {
        return physicEntity;
    }

    public JLabel getGraphicEntity() { return graphicEntity; }

    public int getId() { return id; }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setPhysicEntity(PhysicEntity physicEntity) {
        this.physicEntity = physicEntity;
    }

    public void setGraphicEntity(JLabel graphicEntity) {
        this.graphicEntity = graphicEntity;
    }
}
