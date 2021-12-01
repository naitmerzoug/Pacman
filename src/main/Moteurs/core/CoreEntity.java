package Moteurs.core;

import Moteurs.physic.PhysicEntity;
import Moteurs.physic.Type;

public class CoreEntity {

    private int id = 0;
    private PhysicEntity physicEntity;
    //private GraphicEntity graphicEntity;

    // Getters

    public PhysicEntity getPhysicEntity() {
        return physicEntity;
    }

    //public GraphicEntity getGraphicEntity() {
   //     return graphicEntity;
   // }

    public int getId() {
        return id;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setPhysicEntity(PhysicEntity physicEntity) {
        this.physicEntity = physicEntity;
    }
}
