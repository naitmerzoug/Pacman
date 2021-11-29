//package Moteurs.graphic;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//
//public class GraphicScene extends JPanel {
//
//    protected int height;
//    protected int width;
//
//    protected Graphics2D graphics2D;
//
//    private final ArrayList<Gentity> entityArrayList = new ArrayList<>();
//
//    protected GraphicScene(int width, int height){
//        this.width = width;
//        this.height = height;
//        setBackground(Color.BLACK);
//    }
//
//    protected void addEntity(Gentity entity){
//        if (!entityArrayList.contains(entity)){
//            entityArrayList.add(entity);
//        }
//    }
//
//    protected void removeEntity(Gentity entity){
//        entityArrayList.remove(entity);
//    }
//}
