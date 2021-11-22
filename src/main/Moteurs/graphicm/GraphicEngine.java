package Moteurs.graphicm;

import java.util.ArrayList;

/**
 * Moteur graphique
 */
public class GraphicEngine {
    private final ArrayList<GraphicEntity> entities = new ArrayList<>();  // liste des entites graphiques
    private final GraphicScene scene = new GraphicScene(750, 750);

    /**
     * Constructeur
     */
    public GraphicEngine() {}

    // Entités
    public void add_entity(GraphicEntity g) { entities.add(g); }
    public void remove_entity(GraphicEntity g)
    {
        entities.remove(g);
    }







}
