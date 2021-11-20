package Moteurs.graphic;

import javax.swing.*;
import java.awt.*;

public class Window {

    private final JFrame window = new JFrame();

    public void initWindow(String title){
        window.setTitle(title);
        Dimension windowSize = window.getSize();
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = graphicsEnvironment.getCenterPoint();

        window.setSize(1000, 800);

        int dx = (centerPoint.x - windowSize.width/2)-(1000/2);
        int dy = (centerPoint.y - windowSize.height/2)-(800/2);

        window.setLocation(dx, dy);
        window.setLayout( new FlowLayout() );
        window.setVisible(true);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        Window window = new Window();
        window.initWindow("Pacman");

     //   Scene scene = new Scene(800, 800);

    }
}
