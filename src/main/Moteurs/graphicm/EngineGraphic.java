package Moteurs.graphicm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class EngineGraphic{

    private  int width;  // largeur de la scene
    private  int height; // hauteur de la scene
    private JFrame frame;  // creation de la fenetre

    /**
     * Création d'un fond
     * @param width_bg
     * @param height_bg
     * @param color_bg
     */
    protected EngineGraphic(int width_bg, int height_bg, Color color_bg, String name){
        this.width = width_bg;
        this.height = height_bg;
        frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // en cas de fermeture
        frame.setSize(width, height);                           // taille de la fenetre
        frame.getContentPane().setBackground(color_bg);      // couleur du background
    }

    /**
     * Lance la fenetre
     */
    public void run(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //afficher scene
                frame.setVisible(true);
            }
        });
    }

    public JLabel createEntity(int height, int width, File file){
        JLabel jLabel = new JLabel();

        //chargement d'une image
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        //Redimensionnement image
        image = (BufferedImage) resizeToBig(image, width,height);
        ImageIcon imageIcon = new ImageIcon(image);

        jLabel.setIcon(imageIcon);

        return jLabel;
    }

    public void addEntity(JLabel entity, int x, int y){
        frame.getContentPane().add(entity);
        entity.setBounds(x, y,entity.getWidth(),entity.getHeight());
    }

    public Component[] getAll() {
        return frame.getContentPane().getComponents();
    }

    public void printEntities(){
        for( Component test : frame.getContentPane().getComponents())
            System.out.println(test.getX()+" "+test.getY());
    }

    public void mooveEntity(Component jLabel, int x, int y){
        //Debug affiche les coordonées du composant pour tester si coordonées de l'objet / Jlabel == coordonées composant
        System.out.println(frame.getContentPane().getComponent(0).getY()+ ":" + frame.getContentPane().getComponent(0).getX());
        jLabel.setBounds(x, y, jLabel.getWidth(), jLabel.getHeight());
    }

    //======================================
    //           GETTER - SETTER
    //======================================
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    /**
     * Fonction récupérée sur internet.
     * we want the x and o to be resized when the JFrame is resized
     *
     * @param originalImage an x or an o. Use cross or oh fields.
     *
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

}
