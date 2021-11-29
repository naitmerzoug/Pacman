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

    /**
     * Hauteur et largeur de l'espace graphique
     */
    private int GraphicHeight, GraphicWidth;

    /**
     * Hauteur et largeur de l'espace physique
     */
    private double PhysicHeight, PhysicWidth;
    private IOEngine ioEngine;
    private GraphicEngine graphicEngine;
    private PhysicEngine physicEngine;
    private ConcurrentMap<Integer,CoreEntity> entities;
    public static int nbEntities;

    public CoreEngine(double physicHeight, double physicWidth, int graphicHeight, int graphicWidth){

        // Tailles des espaces physiques et graphiques
        this.PhysicHeight = physicHeight;
        this.PhysicWidth = physicWidth;
        this.GraphicHeight = graphicHeight;
        this.GraphicWidth = graphicWidth;

        // Attributs
        nbEntities = 0;

        // Moteurs
        this.ioEngine = new IOEngine();
        this.graphicEngine = new GraphicEngine();
        this.physicEngine = new PhysicEngine();
        this.entities = new ConcurrentHashMap<>();
    }

    /**
     * Ajoute une entité noyau
     */
    public void addEntity(CoreEntity e){
        if(e.getId()==0 || entities.containsKey(e.getId())){
            nbEntities++;
            e.setId(nbEntities);
        }
        entities.put(e.getId(),e);
        this.getPhysicEngine().createEntity(e.getPhysicEntity());
        //penser a ajouter graphique aussi
    }

    /**
     * Supprime une entité noyau
     */
    public void removeEntity(CoreEntity e){
        entities.remove(e.getId());
    }

    /**
     * Converti des coordonnées de l'espace physique en espace graphique
     * Valable pour l'axe des abscisses et pour les tailles en général
     */
    public int ConvertPhysictoGraphic(double x)
    {
        int graphicWidth = this.getGraphicWidth();
        double physicWidth = this.getPhysicWidth();
        return (int) ((graphicWidth * x) / physicWidth);

    }

    /**
     * Converti des coordonnées de l'espace physique en espace graphique pour l'axe des ordonnées
     */
    public int ConvertPhysictoGraphicOrd(double y)
    {
        int graphicHeight = this.getGraphicHeight();
        double physicHeight = this.getPhysicHeight();
        return (int) (-(graphicHeight * y) / physicHeight);

    }


    // Getters

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

    public double getPhysicHeight() { return PhysicHeight; }

    public double getPhysicWidth() { return PhysicWidth; }

    public int getGraphicHeight() { return GraphicHeight; }

    public int getGraphicWidth() { return GraphicWidth; }

    // Setter

    public static void setNbEntities(int nbEntities) {
        CoreEngine.nbEntities = nbEntities;
    }

}
