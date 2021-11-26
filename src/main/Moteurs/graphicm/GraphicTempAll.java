package Moteurs.graphicm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class GraphicTempAll extends JFrame {

    private static int width;  // largeur de la scene
    private static int height; // hauteur de la scene
    private static JFrame frame = new JFrame("Pacman");  // creation de la fenetre

    public BufferedImage image2;

    protected GraphicTempAll(int width, int height){
        this.width = width;
        this.height = height;

//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // en cas de fermeture
//        frame.setSize(width, height); // taille de la fenetre
//        frame.getContentPane().setBackground(Color.BLACK);  // couleur du background
    }

    public void addEntity(JLabel jlabel){
        frame.getContentPane().add(jlabel);
    }


    public static void AfficherScene(JLabel jLabel, JLabel jLabel2) throws InterruptedException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // en cas de fermeture
        frame.setSize(width, height); // taille de la fenetre
        frame.getContentPane().setBackground(Color.BLACK);  // couleur du background

        BufferedImage image = null;
        try // chargement image
        {
            image = ImageIO.read(new File("src\\main\\Moteurs\\graphicm\\pacman.png"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        image = (BufferedImage) resizeToBig(image, 10,10);
        ImageIcon imageIcon = new ImageIcon(image);

        jLabel.setIcon(imageIcon);
        Dimension size = jLabel.getPreferredSize();
        jLabel.setBounds(300, 250, size.width, size.height);
        frame.getContentPane().add(jLabel);



        BufferedImage image2 = null;
        try // chargement image
        {
            image2 = ImageIO.read(new File("src\\main\\Moteurs\\graphicm\\pacman.png"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        image2 = (BufferedImage) resizeToBig(image2, 100,10);
        ImageIcon imageIcon2 = new ImageIcon(image2);

        jLabel2.setIcon(imageIcon2);
        Dimension size2 = jLabel2.getPreferredSize();
        frame.getContentPane().add(jLabel2);
       //




        System.out.println("test");

        frame.setVisible(true);  // affichage
        jLabel2.setBounds(300, 150, size2.width, size2.height);

    }

    /**
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

    public static void main(String[] args) throws InterruptedException {
        GraphicTempAll g = new GraphicTempAll(750, 750);
        JLabel jLabel2 = new JLabel();
        JLabel jLabel1 = new JLabel();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    AfficherScene(jLabel1,jLabel2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        jLabel2.setBounds(100, 125, jLabel2.getWidth(), jLabel2.getHeight());
        for(int i=0; i<500 ; i++) {
            for( Component test : frame.getContentPane().getComponents())
                System.out.println(test.getX()+" "+test.getY());//Thread.currentThread().sleep(300);
//            Dimension size = jLabel1.getPreferredSize(); // Définition taille 1
//            Dimension size2 = jLabel2.getPreferredSize(); // Définition taille 2
            System.out.println("des tests");
//            Component[] x = frame.getContentPane().getComponents();
//            if(i==1)
//                jLabel2.setBounds(100, 125, jLabel2.getWidth(), jLabel2.getHeight());
//            jLabel2.setBounds(x[1].getX()+1, x[1].getY(), size2.width, size2.height);
//            if (x[0].getY()-5>=0)
//                jLabel1.setBounds(x[0].getX(), x[0].getY()-5, size.width, size.height);
        }

    }
}
