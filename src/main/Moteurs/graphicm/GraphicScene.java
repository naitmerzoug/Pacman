package Moteurs.graphicm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class GraphicScene extends JFrame {

    protected static int width;  // largeur de la scene
    protected static int height; // hauteur de la scene
    protected static JFrame frame = new JFrame("Pacman");  // creation de la fenetre

    private final ArrayList<GraphicEntity> entityArrayList = new ArrayList<>();  // liste des entites graphiques

    public BufferedImage image2;

    protected GraphicScene(int width, int height){
        this.width = width;
        this.height = height;
    }

    public static void AfficherScene(JLabel jLabel, JLabel jLabel2) throws InterruptedException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // en cas de fermeture
        frame.setSize(width, height); // taille de la fenetre
        frame.getContentPane().setBackground(Color.BLACK);  // couleur du background
/*        Canvas c = new Canvas();
//        Image i = c.createImage(width, height);
        //frame.add(new ImageCanvas());

//        JPanel jPanel= new JPanel() {
//            public BufferedImage image;
//
//            @Override
//            protected void paintComponent(Graphics g) {
//                // load image
//
//                try {
//                    image = ImageIO.read(new URL("https://i.stack.imgur.com/XNO5e.png"));
//                } catch (MalformedURLException ex) {
//                    System.out.println("catch Malformed");;
//                } catch (IOException ex) {
//                    System.out.println("catch IOException");;
//                }
//
//                super.paintComponent(g);
//                g.drawImage(image, 500, 50, this);
//            }
//
//            @Override
//            public Dimension getPreferredSize() {
//                return new Dimension(image.getWidth(), image.getHeight());
//            }
//
//        };
//        frame.add(jPanel); */
        BufferedImage image = null;
        try
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
        jLabel.setBounds(550, 500, size.width, size.height);
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
        image2 = (BufferedImage) resizeToBig(image2, 10,10); //resyze image
        ImageIcon imageIcon2 = new ImageIcon(image2);

        jLabel2.setIcon(imageIcon2);

        size = jLabel2.getPreferredSize(); // Définition taille 1
        jLabel2.setBounds(150, 100, size.width, size.height); // Définition taille 2

        frame.getContentPane().add(jLabel2);
        System.out.println("test");
        frame.setVisible(true);  // affichage


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
        GraphicScene g = new GraphicScene(750, 750);
        JLabel jLabel2 = new JLabel();JLabel jLabel1 = new JLabel();
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

        for(int i=0; i<500 ; i++) {
            for( Component test : frame.getContentPane().getComponents())
                System.out.println(test.getX()+" "+test.getY());
            Thread.currentThread().sleep(300);
            Dimension size = jLabel2.getPreferredSize(); // Définition taille 1
            System.out.println("des tests");
            Component[] x = frame.getContentPane().getComponents();
            jLabel2.setBounds(x[1].getX()+1, x[1].getY(), size.width, size.height);
            if (x[0].getY()-5>=0)
                jLabel1.setBounds(x[0].getX(), x[0].getY()-5, size.width, size.height);
        }

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
