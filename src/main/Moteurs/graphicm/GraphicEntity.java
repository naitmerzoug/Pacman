package Moteurs.graphicm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Set;

/**
 * Entité graphique
 */
public class GraphicEntity {

    private int x; // Position x
    private int y; // Position y
    private int height;
    private int width;
    private Etat etat;
    private JLabel jLabel;

    //list image
    public HashMap<Etat, Set<BufferedImage>> images;

    private Color color;

    /**
     *
     * @param x
     * @param y
     * @param height
     * @param width
     * @param file temporaire puis ce sera une liste de File
     */
    public GraphicEntity(int x, int y, int height, int width, File file){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;

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

        this.jLabel = jLabel;
    }

    // Getters

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor(){
        return color;
    }

    // Setters

    public void setX(int x) {
        this.x = x;
        //Positionement entité
        jLabel.setBounds(x, y, jLabel.getWidth(), jLabel.getHeight());
    }

    public void setY(int y) {
        this.y = y;
        //Positionement entité
        jLabel.setBounds(x, y, jLabel.getWidth(), jLabel.getHeight());
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
        //Positionement entité
        jLabel.setBounds(x, y, jLabel.getWidth(), jLabel.getHeight());
        System.out.println("setpos x:"+jLabel.getX()+" y:"+jLabel.getY());
    }

    public void setHeight(int height) {
        this.height = height;
        //Positionement entité
        jLabel.setBounds(x, y, jLabel.getWidth(), height);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setColor(Color color) {
        this.color = color;
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


    public Component getJlabel() {
        return jLabel;
    }
}

