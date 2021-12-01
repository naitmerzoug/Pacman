package Moteurs.inout;


import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;

public class IOEngine {

    private int keyCode;
    private Date date = null;

    public IOEngine() {
    }

    public IOEngine notifyInput(KeyEvent event) {
        date = Calendar.getInstance().getTime();
        keyCode = event.getKeyCode();

        return this;
    }

    public Date getDate() {
        return date;
    }

    public int getKeyCode() {
        return keyCode;
    }


}
