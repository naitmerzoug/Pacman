package Moteurs.graphicm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphicScene extends JFrame {

    protected static int width;  // largeur de la scene
    protected static int height; // hauteur de la scene
    protected static JFrame frame = new JFrame("PacmanGame");  // creation de la fenetre

    private final ArrayList<GraphicEntity> entityArrayList = new ArrayList<>();  // liste des entites graphiques

    protected GraphicScene(int width, int height){
        this.width = width;
        this.height = height;
    }

    public static void AfficherScene()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // en cas de fermeture
        frame.setSize(width, height); // taille de la fenetre
        frame.getContentPane().setBackground(Color.BLACK);  // couleur du background
        frame.setVisible(true);  // affichage

    }

    public static void main(String[] args) {
        GraphicScene g = new GraphicScene(750, 750);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AfficherScene();
            }

    });
    }

    /**
     * Ajoute une entité graphique à la scène

    protected void addEntity(GraphicEntity entity){
        if (!entityArrayList.contains(entity)){
            entityArrayList.add(entity);
        }
    }

    /**
     * Supprime une entité graphique à la scène

    protected void removeEntity(GraphicEntity entity){
        entityArrayList.remove(entity);
    }
    */
}
