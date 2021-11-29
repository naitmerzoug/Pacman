package Moteurs.core;

import Moteurs.graphicm.GraphicEntity;
import Moteurs.physic.PhysicEntity;
import Moteurs.physic.Type;

public class CoreEntity {

    private int id = 0;
    private PhysicEntity physicEntity;
    private GraphicEntity graphicEntity;

    public CoreEntity(Type type, double x, double y, double height, double width, int speed)
    {
        this.physicEntity = new PhysicEntity(id, type, x, y, height, width, speed);
        // conversion dans l'espace de coordonnées graphiques
        //this.graphicEntity = new GraphicEntity(convertPhysictoGraphic(x), convertPhysictoGraphic(y),convertPhysictoGraphic(height), convertPhysictoGraphic(width));
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
