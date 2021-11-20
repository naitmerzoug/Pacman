package Moteurs.graphic;

import Moteurs.core.Entity;

import java.util.ArrayList;

/**
 * Moteur graphique
 */
public class Graphic {

    private final ArrayList<Gentity> entities = new ArrayList<>();

    public Graphic(){}

    public Gentity createEntity(Entity parent){
        Gentity entity = new Gentity(parent);
        entities.add(entity);
        return entity;
    }

    public void removeEntity(Entity entity){
        entities.remove(entity);
    }

    // Getter //

    public ArrayList<Gentity> getEntities() {
        return entities;
    }

}