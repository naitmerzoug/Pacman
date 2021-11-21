package Moteurs.inout;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;

public class KeyboardIO implements KeyListener {

    private final IOEngine ioEngine;

    private final ArrayList<Integer> pressedKeys = new ArrayList<>();

    public KeyboardIO(IOEngine ioEngine){
        this.ioEngine = ioEngine;
    }

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if (!pressedKeys.contains(key)){
            pressedKeys.add(key);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (pressedKeys.contains(key))
            pressedKeys.remove((Integer) key);
    }

    public ArrayList<Integer> getPressedKeys() {
        return pressedKeys;
    }
}
