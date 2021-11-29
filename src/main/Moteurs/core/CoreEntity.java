package Moteurs.core;

import Moteurs.graphicm.GraphicEntity;
import Moteurs.physic.PhysicEntity;


public class CoreEntity {

    private int id;
    private int x, y;
    private PhysicEntity physicEntity;
    private GraphicEntity graphicEntity;

    public CoreEntity(int id, int x, int y)
    {
        this.id = id;
        this.physicEntity = new PhysicEntity();
        this.graphicEntity = new GraphicEntity();
    }

    public CoreEntity()
    {
        this.id = id;
        this.physicEntity = new PhysicEntity();
        this.graphicEntity = new GraphicEntity();
    }

    public int convertPhytoGraph(double nb)
    {
        int new_nb;
        new_nb = 0; // à faire
        return new_nb;
    }
    // Getters

    public PhysicEntity getPhysicEntity() {
        return physicEntity;
    }

    public GraphicEntity getGraphicEntity() {
        return graphicEntity;
    }

    public int getId() {
        return id;
    }

    // Setters

    public void setId(int id) {
        this.id = id;
    }
}
