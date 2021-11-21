package Utils;

/**
 * Ce package est utilisé comme une sorte d'API vers Swing
 */
public class Main {
    private Renderer renderer;

    public Main(){
        this.renderer = new Renderer();
    }

    // getter //

    public Renderer getRenderer() {
        return renderer;
    }
}
