package Moteurs.graphic;

import Moteurs.core.Entity;

import java.util.ArrayList;

/**
 * Moteur graphique
 */
public class GraphicEngine {

    private final ArrayList<GraphicEntity> entities = new ArrayList<>();

    public GraphicEngine(){}

    public GraphicEntity createEntity(Entity parent){
        GraphicEntity entity = new GraphicEntity(parent);
        entities.add(entity);
        return entity;
    }

    public void removeEntity(Entity entity){
        entities.remove(entity);
    }

    // Getter //

    public ArrayList<GraphicEntity> getEntities() {
        return entities;
    }

}
