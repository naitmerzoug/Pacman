package Moteurs.inout;

import static junit.framework.TestCase.*;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class InoutTest {

    IOEngine ioEngine = new IOEngine();

    private Status status;
    private int keyCode;
    private static KeyEvent keyEvent;

    private Robot robot = new Robot();
    public InoutTest() throws AWTException {
    }

    @Test
    public void assertKeyUpPressed(){
        System.out.println("\nOn appuie sur la flèche du haut");
        robot.keyPress(KeyEvent.VK_UP);
        assertEquals(38, keyEvent.VK_UP);
        System.out.println("Flèche du haut pressé");
        robot.keyRelease(KeyEvent.VK_UP);
    }

    @Test
    public void assertKeyDownPressed(){
        System.out.println("\nOn appuie sur la flèche du bas");
        robot.keyPress(KeyEvent.VK_UP);
        assertEquals(40, keyEvent.VK_DOWN);
        System.out.println("Flèche du bas pressé");
        robot.keyRelease(KeyEvent.VK_UP);
    }

    @Test
    public void assertKeyRightPressed(){
        System.out.println("\nOn appuie sur la flèche de droite");
        robot.keyPress(KeyEvent.VK_UP);
        assertEquals(39, keyEvent.VK_RIGHT);
        System.out.println("Flèche de droite pressé");
        robot.keyRelease(KeyEvent.VK_UP);
    }

    @Test
    public void assertKeyLeftPressed(){
        System.out.println("\nOn appuie sur la flèche de gauche");
        robot.keyPress(KeyEvent.VK_LEFT);
        assertEquals(37, keyEvent.VK_LEFT);
        System.out.println("Flèche de gauche pressé");
        robot.keyRelease(KeyEvent.VK_LEFT);
    }

    @Test
    public void assertKeyPPressed(){
        System.out.println("\nOn appuie sur la touche P du clavier");
        robot.keyPress(KeyEvent.VK_LEFT);
        assertEquals(80, keyEvent.VK_P);
        System.out.println("Touche P du clavier pressé");
        robot.keyRelease(KeyEvent.VK_LEFT);
    }

    @Test
    public void assertPressedKeys(){
        robot.keyPress(KeyEvent.VK_LEFT);
        assertTrue(new KeyboardIO(38, Status.UP).getPressedKeys().size()==1);
        robot.keyRelease(KeyEvent.VK_LEFT);
    }
}
