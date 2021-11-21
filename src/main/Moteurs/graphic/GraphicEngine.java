package Moteurs.graphic;

import Moteurs.core.Entity;

import java.util.ArrayList;

/**
 * Moteur graphique
 */
public class GraphicEngine {

    private final ArrayList<Gentity> entities = new ArrayList<>();

    public GraphicEngine(){}

    public Gentity createEntity(Entity parent){
        Gentity entity = new Gentity(parent);
        entities.add(entity);
        return entity;
    }

    public void removeEntity(Entity entity){
        entities.remove(entity);
    }

    public void move(Entity entity, int x, int y){
        entity.getGraphicEntity().setX(x);
        entity.getGraphicEntity().setY(y);
    }

    // Getter //

    public ArrayList<Gentity> getEntities() {
        return entities;
    }

}
