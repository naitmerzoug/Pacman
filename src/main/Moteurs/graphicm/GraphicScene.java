package Moteurs.graphicm;

import javax.swing.*;
import java.awt.*;

public class GraphicScene extends JFrame {

    private final int width;  // largeur de la scene
    private final int height; // hauteur de la scene
    private JFrame frame = new JFrame("Pacman");  // creation de la fenetre

    protected GraphicScene(int width, int height,Color color){
        this.width = width;
        this.height = height;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // en cas de fermeture
        frame.setSize(width, height);                           // taille de la fenetre
        frame.getContentPane().setBackground(color);      // couleur du background
    }

    public  void afficherScene()  {
        frame.setVisible(true);  // affichage
    }

    public void run(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                afficherScene();
            }
        });
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    /**
     * Ajoute une entité graphique à la scène
     * @param graphicEntity
     */
    public void addEntity(GraphicEntity graphicEntity){
        frame.getContentPane().add(graphicEntity.getJlabel());
    }

    /**
     * Supprime une entité graphique à la scène

    protected void removeEntity(GraphicEntity entity){
        entityArrayList.remove(entity);
    }
    */
    public void removeEntity(JLabel jLabel){
        frame.remove(jLabel);
    }

    public Component[] getAll() {
        return frame.getContentPane().getComponents();
    }

    public void printEntities(){
        for( Component test : frame.getContentPane().getComponents())
            System.out.println(test.getX()+" "+test.getY());
    }
}
