package Moteurs.graphicm;

import java.awt.*;
import java.util.ArrayList;

/**
 * Moteur graphique
 */
public class GraphicEngine {
    private final ArrayList<GraphicEntity> entities = new ArrayList<>();  // liste des entites graphiques
    private final GraphicScene scene = new GraphicScene(750, 750, Color.BLACK);

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

    public static void main(String[] args) {
       // GraphicEngine graphicEngine = new GraphicEngine();
        System.out.println("Salut");
    }

    // Initialiser une entité
        //initialiser une map de list d'image
        //initialiser un etat de l'objet

    //fixer un etat à l'objet (changer de liste de diffusion)

    //afficher tout les objets

    //initialiser la scene

    //actualiser





}
