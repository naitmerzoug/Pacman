package Moteurs.inout;


public class IOEngine implements IOEvent{

    private final KeyboardIO keyboardIO = new KeyboardIO(this);

    public IOEngine() {};

    @Override
    public void notifyInput(String event){

    }

    @Override
    public void notifyClick(){

    }
    /*
    public void keyPressed(KeyEvent evt) {
        int code = evt.getKeyCode();

        if (code == KeyEvent.VK_UP) System.out.println("Haut");
        else if (code == KeyEvent.VK_DOWN) System.out.println("Bas");
        else if (code == KeyEvent.VK_RIGHT) System.out.println("Droite");
        else if (code == KeyEvent.VK_LEFT) System.out.println("Gauche");
    }

     */

}
