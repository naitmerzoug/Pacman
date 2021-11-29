package Moteurs.core;

import Moteurs.graphic.GraphicEngine;
import Moteurs.inout.IOEngine;
import Moteurs.physic.PhysicEngine;

/**
 * Noyau du jeu
 * Doit contenir un accès à tous les autres moteurs
 */
public class CoreEngine {

    private IOEngine ioEngine;
    private GraphicEngine graphicEngine;
    private PhysicEngine physicEngine;

    public CoreEngine(){
        this.ioEngine = new IOEngine();
        this.graphicEngine = new GraphicEngine();
        this.physicEngine = new PhysicEngine();
    }

    // Getter //

    public GraphicEngine getGraphicEngine() {
        return graphicEngine;
    }

    public IOEngine getIoEngine() {
        return ioEngine;
    }

    public PhysicEngine getPhysicEngine() {
        return physicEngine;
    }
}
