package Moteurs.graphicm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * CLASS TEST : NE PAS PRENDRE EN COMPTE POUR L EVALUTATION OU LE PROJET
 * Test: Repositionner un JLabel
 */
public class ComponentDragger extends MouseAdapter {

    private Component target;

    /**
     * {@inheritDoc}
     */
    @Override
    public void mousePressed(MouseEvent e) {
        Container container = (Container) e.getComponent();
        for (Component c : container.getComponents()) {
            if (c.getBounds().contains(e.getPoint())) {
                target = c;
                break;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        if (target != null) {
            target.setBounds(e.getX(), e.getY(), target.getWidth(), target.getHeight());
            e.getComponent().repaint();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        target = null;
    }

    public static void main(String[] args) {
        JLabel label = new JLabel("Drag Me");
        JPanel panel = new JPanel();
        panel.add(label);
        ComponentDragger dragger = new ComponentDragger();
        panel.addMouseListener(dragger);
        panel.addMouseMotionListener(dragger);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1024, 768);
        f.add(panel);
        f.setVisible(true);
        panel.setLayout(null);
        f.setState(Frame.MAXIMIZED_BOTH);
    }
}