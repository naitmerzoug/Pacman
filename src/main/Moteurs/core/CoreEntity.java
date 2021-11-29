package Moteurs.core;

import Moteurs.graphicm.GraphicEntity;
import Moteurs.physic.PhysicEntity;
import Moteurs.physic.Type;


public class CoreEntity {

    private int id;
    private double x, y;
    private PhysicEntity physicEntity;
    private GraphicEntity graphicEntity;

    public CoreEntity(int id, Type type, double x, double y, double height, double width, int speed)
    {
        this.id = id;
        this.x = x;
        this.y = y;
        this.physicEntity = new PhysicEntity(id, type, x, y, height, width, speed);
        // conversion dans l'espace de coordonnées graphique
        this.graphicEntity = new GraphicEntity(convertPhysictoGraphic(x), convertPhysictoGraphic(y),convertPhysictoGraphic(height), convertPhysictoGraphic(width));
    }

    public int convertPhysictoGraphic(double nb)
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
