import Moteurs.graphic.Scene;

import javax.swing.*;
import java.awt.*;

public class Main {

    private final JFrame window = new JFrame();

    private static Scene actualScene;

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
        Main main = new Main();
        main.initWindow("Pacman");
    }
}
