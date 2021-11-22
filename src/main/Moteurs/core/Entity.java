package Moteurs.core;

import Moteurs.graphic.Gentity;

public class Entity extends EngineEntity{

    protected Gentity graphicEntity;
    protected CoreEngine coreEngine;

    /**
     * Il faut un attribut aussi pour le moteur physique + moteur IA
     */

    public Entity(CoreEngine coreEngine){
        // Il faut ajouter une entité pour chaque moteur
        this.graphicEntity = coreEngine.getGraphicEngine().createEntity(this);
    }

    public Gentity getGraphicEntity() {
        return graphicEntity;
    }

    public CoreEngine getCoreEngine() {
        return coreEngine;
    }
}
