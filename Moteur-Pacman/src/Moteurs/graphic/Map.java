package Moteurs.graphic;

import Moteurs.graphic.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Map extends JFrame implements ActionListener{
    Element pacman;

    private Timer timer = new Timer(50, this);
    public Map(String title){
        super(title);

        int width = 1000;
        int height = 800;

        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        setSize(width, height);

        int dx = (centerPoint.x - windowSize.width/2)-(width/2);
        int dy = (centerPoint.y - windowSize.height/2)-(height/2);

        setLocation(dx, dy);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout( new FlowLayout() );
    }

    @Override
    public void paint(Graphics g){
        g.setColor(Color.decode("#0082E6"));
        g.fillRect(0, 0, 800, 800);

        pacman = new Element(100, 100, 50, "#F7F60C");
        g.setColor(Color.decode(pacman.getColor()));
        g.fillOval(pacman.getX(), pacman.getY(), pacman.getSize(), pacman.getSize());

        g.setColor(Color.decode("#AD6D0C"));
        g.fillRect(800, 0, 800, 800);
    }

    public static void main(String[] args){
        JFrame map = new Map("PacMan");
        map.setVisible(true);
    }
}
