package Moteurs.inout;

import java.awt.event.KeyEvent;


public class InOut {

    public void keyPressed(KeyEvent evt) {
        int code = evt.getKeyCode();

        if (code == KeyEvent.VK_UP) System.out.println("Haut");
        else if (code == KeyEvent.VK_DOWN) System.out.println("Bas");
        else if (code == KeyEvent.VK_RIGHT) System.out.println("Droite");
        else if (code == KeyEvent.VK_LEFT) System.out.println("Gauche");
    }

    public static void main (String args[])
    {

    }
}
