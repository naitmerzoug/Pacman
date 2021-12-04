package Moteurs.core;

import Moteurs.physic.PhysicEntity;
import javax.swing.*;

/**
 * Entité noyau
 */
public class CoreEntity {
    /**
     * Identifiant unique d'une entité
     */
    private int id = 0;

    /**
     * Entité physique
     */
    private PhysicEntity physicEntity;

    /**
     * Entité graphique
     */
    private JPanel graphicEntity;

    // Getters

    public PhysicEntity getPhysicEntity() { return physicEntity; }

    public JPanel getGraphicEntity() { return graphicEntity; }

    public int getId() { return id; }

    // Setters

    public void setId(int id) { this.id = id; }

    public void setPhysicEntity(PhysicEntity physicEntity) { this.physicEntity = physicEntity; }

    public void setGraphicEntity(JPanel graphicEntity) { this.graphicEntity = graphicEntity; }
}
