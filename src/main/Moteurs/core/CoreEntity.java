package Moteurs.core;

/**
 * Classe mère des entités
 */
public abstract class CoreEntity {

    protected Entity parent;

    protected CoreEntity(){}

    protected CoreEntity(Entity parent){
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
