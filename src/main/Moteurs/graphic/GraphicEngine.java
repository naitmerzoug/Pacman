package Moteurs.graphic;

import Moteurs.core.CoreEngine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphicEngine extends JPanel implements KeyListener {

    private final int width;  // largeur de la scene
    private final int height; // hauteur de la scene
    private final JFrame frame;  // creation de la fenetre
    private final JPanel jPanel;
    private final CoreEngine coreEngine;
    private KeyEvent lastPressed = null;


    /**
     * Création d'un fond
     *
     * @param width_bg
     * @param height_bg
     * @param color_bg
     * @param name
     */
    public GraphicEngine(int width_bg, int height_bg, Color color_bg, String name) {
        width = width_bg;
        height = height_bg;
        frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // en cas de fermeture
        frame.setSize(width, height);
        jPanel = new JPanel();               // taille de la fenetre
        jPanel.setBackground(color_bg);      // couleur du background
        frame.addKeyListener(this);        // écouteur d'évenement clavier
        frame.add(jPanel);
        coreEngine = null;
    }

    //======================================
    //           Gestion évènement & Ecouteurs
    //======================================
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //debug
        System.out.println("A key is Pressed: " + e.getKeyCode());
        this.lastPressed = e;
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Spacebutton pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //======================================
    //           Gestion graphique & Affichage
    //======================================

    /**
     * Lance la fenetre
     */
    public void run() {
        SwingUtilities.invokeLater(() -> {
            //afficher scene
            frame.setVisible(true);
        });
    }

    public JLabel createEntity(int height, int width, File file) {
        JLabel jLabel = new JLabel();

        //chargement d'une image
        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        //Redimensionnement image
        image = (BufferedImage) resizeToBig(image, width, height);
        ImageIcon imageIcon = new ImageIcon(image);

        jLabel.setIcon(imageIcon);
        jLabel.setLayout(null);
        return jLabel;
    }

    public void addEntity(JLabel entity, int x, int y) {
        jPanel.add(entity);
        entity.setBounds(x, y, entity.getWidth(), entity.getHeight());
    }

    public void mooveEntity(Component jLabel, int x, int y) {
        //Debug affiche les coordonées du composant pour tester si coordonées de l'objet / Jlabel == coordonées composant
        //System.out.println(jLabel.getX()+" "+jLabel.getY());
        jLabel.setBounds(x, y, jLabel.getWidth(), jLabel.getHeight());
    }

    //======================================
    //           GETTER - SETTER
    //======================================
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public KeyEvent getLastPressed() {
        return lastPressed;
    }

    /**
     * Fonction récupérée sur internet.
     * we want the x and o to be resized when the JFrame is resized
     *
     * @param originalImage an x or an o. Use cross or oh fields.
     * @param biggerWidth
     * @param biggerHeight
     */
    public static Image resizeToBig(Image originalImage, int biggerWidth, int biggerHeight) {
        int type = BufferedImage.TYPE_INT_ARGB;


        BufferedImage resizedImage = new BufferedImage(biggerWidth, biggerHeight, type);
        Graphics2D g = resizedImage.createGraphics();

        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.drawImage(originalImage, 0, 0, biggerWidth, biggerHeight, null);
        g.dispose();


        return resizedImage;
    }


    //======================================
    //           Debug
    //======================================
    public void printEntities() {
        for (Component test : jPanel.getComponents())
            System.out.println(test.getX() + " " + test.getY());
    }

    public Component[] getAll() {
        return jPanel.getComponents();
    }

    public ArrayList<Component> getEntities() {
        return (ArrayList<Component>) Arrays.asList(jPanel.getComponents());
    }
}
