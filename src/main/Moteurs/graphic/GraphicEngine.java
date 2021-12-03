package Moteurs.graphic;

import Moteurs.core.CoreEngine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Moteur graphique
 */
public class GraphicEngine extends JPanel implements KeyListener {

    /**
     * Largeur de la scène
     */
    private final int width;

    /**
     * Hauteur de la scène
     */
    private final int height;

    /**
     * Création de la fenêtre
     */
    private final JFrame frame;

    /**
     * Moteur noyau
     */
    private CoreEngine coreEngine;

    /**
     * Contient la dernière touche appuyée
     */
    private KeyEvent lastPressed = null;


    /**
     * Création d'un fond
     * @param name Nom du jeu
     * @param color_bg Couleur du fond
     * @param height_bg Hauteur du fond
     * @param width_bg Largeur du fond
     */
    public GraphicEngine(int width_bg, int height_bg, Color color_bg, String name) {
        width = width_bg;
        height = height_bg;

        frame = new JFrame(name);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // en cas de fermeture
        frame.getContentPane().setBackground(color_bg);
        frame.setLayout(null);
        frame.addKeyListener(this);        // écouteur d'évenement clavier
    }

    public void setCoreEngine(CoreEngine coreEngine) {
        this.coreEngine = coreEngine;
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
        coreEngine.sendKeyEvent(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //======================================
    //           Gestion graphique & Affichage
    //======================================

    /**
     * Lance la fenêtre
     */
    public void run() {
        SwingUtilities.invokeLater(() -> {
            //afficher scene
            frame.setVisible(true);
        });
    }

    /**
     * Création d'une entité
     * @param file Chemin du fichier image
     * @param height Hauteur
     * @param width Largeur
     * @return Entité physique
     */
    public JPanel createEntity(int height, int width, File file) {

        //création entité
        JPanel jPanel = new JPanel();
        jPanel.setBounds(0,0, width, height);
        jPanel.setLayout(null);
        jPanel.setBackground(null);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(0,0,width,height);

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

        jPanel.add(jLabel);
        System.out.println("new jpanel create" +
                "");
        return jPanel;
    }

    /**
     * Création et ajout d'une entité
     * @param x Position x
     * @param y Position y
     * @param height Hauteur
     * @param width Largeur
     * @param file Chemin du fichier image
     * @return Entité physique
     */
    public JPanel createAndAddEntity(int x, int y, int height, int width, File file) {

        //création entité
        JPanel jPanel = new JPanel();
        jPanel.setBounds(x, y, width, height);
        jPanel.setLayout(null);
        jPanel.setBackground(null);

        frame.add(jPanel);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(0,0,width,height);

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

        jPanel.add(jLabel);
        return jPanel;
    }

    /**
     * Ajout d'une entité
     * @param entity Entité graphique
     * @param x Position x
     * @param y Position y
     */
    public void addEntity(JPanel entity, int x, int y) {
        frame.add(entity);
        entity.setBounds(x, y, entity.getWidth(), entity.getHeight());
    }

    /**
     * Déplacer une entité
     * @param entity Entité graphique
     * @param x Position x
     * @param y Position y
     */
    public void setPositionEntity(Component entity, int x, int y) {
        entity.setBounds(x, y, entity.getWidth(), entity.getHeight());
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

    public JFrame getFrame() { return frame; }

    public KeyEvent getLastPressed() {
        return lastPressed;
    }

    /**
     * Fonction récupérée sur internet.
     * we want the x and o to be resized when the JFrame is resized
     *
     * @param originalImage an x or an o. Use cross or oh fields.
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


    /**
     * Fonction debug qui récupère toutes les entités
     */
    public Component[] getAll() {
        return frame.getComponents();
    }

}
