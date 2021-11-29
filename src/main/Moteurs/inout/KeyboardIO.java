package Moteurs.inout;


import java.util.ArrayList;

public class KeyboardIO {

    private final ArrayList<Integer> pressedKeys = new ArrayList<>();

    public final int keyCode;
    public final Status status;

    public KeyboardIO(int pKeyCode, Status pStatus){
        this.keyCode = pKeyCode;
        this.status = pStatus;
        pressedKeys.add(keyCode);
    }

    public ArrayList<Integer> getPressedKeys() { return pressedKeys; }

    public void setPressedKeys(int keyCode){
        pressedKeys.add(keyCode);
    }

    public int getKeyCode() {
        return keyCode;
    }

    public Status getStatus() {
        return status;
    }
}
