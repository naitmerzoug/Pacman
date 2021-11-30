package Moteurs.inout;

import java.awt.event.KeyEvent;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class IOEngine {

    private int keyCode;
    private Date date = null;

    public final Map<Integer, String> bindedEventstKeyPressed = new HashMap<>();

    public IOEngine() {
    }

    public IOEngine notifyInput(KeyEvent event) {
        date = Calendar.getInstance().getTime();
        keyCode = event.getKeyCode();

        return this;
    }

    public void bindEventKeyPressed(int keyCode, String eventName){
        bindedEventstKeyPressed.put(keyCode, eventName);
    }

    public void unbindKeyPressed(int keyCode){
        bindedEventstKeyPressed.remove(keyCode);
    }

    // Getter
    public Date getDate() {
        return date;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public Map<Integer, String> getBindedEventstKeyPressed() {
        return bindedEventstKeyPressed;
    }
}