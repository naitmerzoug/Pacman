package Moteurs.core;

public class Entity extends EngineEntity{

    protected CoreEngine coreEngine;

    /**
     * Il faut un attribut aussi pour le moteur physique + moteur IA
     */

    protected Entity(CoreEngine coreEngine){
        // Il faut ajouter une entité pour chaque moteur
        //this.graphicEntity = coreEngine.getGraphicEngine().createEntity(this);
    }
//
//    public Gentity getGraphicEntity() {
//        return graphicEntity;
//    }
}
