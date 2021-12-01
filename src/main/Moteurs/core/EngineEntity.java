package Moteurs.core;

/**
 * Classe mère des entités
 */
public abstract class EngineEntity {

    protected Entity parent;

    protected EngineEntity(){}

    protected EngineEntity(Entity parent){
        this.parent = parent;
    }

    // Getter //

    public Entity getParent() {
        return parent;
    }

    public void setParent(Entity parent) {
        this.parent = parent;
    }
}
