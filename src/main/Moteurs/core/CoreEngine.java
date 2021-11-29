package Moteurs.core;

import Moteurs.graphic.GraphicEngine;
import Moteurs.inout.IOEngine;

/**
 * Noyau du jeu
 * Doit contenir un accès à tous les autres moteurs
 */
public class


CoreEngine {

    private IOEngine ioEngine;
    private GraphicEngine graphicEngine;

    public CoreEngine(){
        this.ioEngine = new IOEngine();
        this.graphicEngine = new GraphicEngine();
    }

    // Getter //

    public GraphicEngine getGraphicEngine() {
        return graphicEngine;
    }

    public IOEngine getIoEngine() {
        return ioEngine;
    }
}
