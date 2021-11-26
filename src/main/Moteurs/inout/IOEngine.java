package Moteurs.inout;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

import java.util.ArrayList;

public class IOEngine{

    private final ArrayList<KeyboardIO> eventsListeners = new ArrayList<>();

    public IOEngine() {};

    public void notifyInput(KeyEvent event){
        int keyCode = event.getKeyCode();
        Status status = null;
        if (keyCode == KeyEvent.VK_UP){
            status = Status.UP;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            status = Status.DOWN;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            status = Status.RIGHT;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            status = Status.LEFT;
        } else if (keyCode == KeyEvent.VK_P){
            status = Status.PAUSE;
        }
        eventsListeners.add(new KeyboardIO(keyCode, status));
    }

    public ArrayList<KeyboardIO> getEventsListeners() {
        return eventsListeners;
    }
}
