package Moteurs.core;

import Moteurs.graphicm.GraphicEngine;
import Moteurs.graphicm.GraphicEntity;
import Moteurs.inout.IOEngine;
import Moteurs.physic.PhysicEngine;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Noyau du jeu
 * Doit contenir un accès à tous les autres moteurs
 */
public class CoreEngine {

    private IOEngine ioEngine;
    private GraphicEngine graphicEngine;
    private PhysicEngine physicEngine;
    private ConcurrentMap<Integer,CoreEntity> entities;
    public static int nbEntities = 0;

    public CoreEngine(){
        this.ioEngine = new IOEngine();
        this.graphicEngine = new GraphicEngine();
        this.physicEngine = new PhysicEngine();
        this.entities = new ConcurrentHashMap<>();
    }

    public void addEntity(CoreEntity e){
        if(e.getId()==0 || entities.containsKey(e.getId())){
            nbEntities++;
            e.setId(nbEntities);
        }
        entities.put(e.getId(),e);
        this.getPhysicEngine().createEntity(e.getPhysicEntity());
    }

    public void removeEntity(CoreEntity e){
        entities.remove(e.getId());
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

    public static int getNbEntities() {
        return nbEntities;
    }

    public ConcurrentMap<Integer, CoreEntity> getEntities() {
        return entities;
    }

    // Setter

    public static void setNbEntities(int nbEntities) {
        CoreEngine.nbEntities = nbEntities;
    }

}
