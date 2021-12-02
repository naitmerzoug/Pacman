package PacmanGame.AI;

import Moteurs.core.CoreEngine;
import PacmanGame.Direction;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class Ghost {


    //public static final double basicSpeed = 1;
    //public static final double scaredSpeed = 1.5;
    //public static final double speed= 1.7;

    public int speed = 1
    // color = 1 Blinky, Color = 2 PINK, Color = 3 Clyde;
    public Direction nextDirection;
    private int color;
    public AiInterface AI;
    public int getSpeed() { return speed; };
    public void setSpeed(int speed) { this.speed = speed; }
    public int getColor() { return color;}
    public void setColor(int color) { this.color = color; }
    //protected double initialX;
    //protected double initialY;
    //private boolean isVulnerable;
    //private CoreEngine coreEngine;

    //public enum State{
    //    TRACK,
    //    SCARED,
    //    DEAD,
    //    NULL
    //}

    public Ghost(int x, int y, int color) {
        this.setPosition(new Point(x, y));
        this.setPixelPosition(new Point(10+getSize()*x, 10+getSize()*y));
        this.color = color;
        switch (color){
            case 1:{
                Image image = new ImageIcon(this.getURLPath(" Blinky ")).getImage();
                this.setImage(image);
                break;
            }
            case 2: {
                Image image = new ImageIcon(this.getURLPath(" Pinky ")).getImage();
                this.setImage(image);
                break;
            }
            case 3: {
                Image image = new ImageIcon(this.getURLPath(" Clyde ")).getImage();
                this.setImage(image);
                break;
            }
            default: {
                Image image = new ImageIcon(this.getURLPath(" Inky ")).getImage();
                this.setImage(image);
                break;
            }
        }

    }
    public Ghost(Point position, GameBoard board) {
        this.setDirection(Direction.STOP);
        this.setPosition(position);
        this.setPixelPosition(new Point(position.x*28, position.y*28));
        this.setGameBoard(board);
        try {
            String path = System.getProperty("user.dir");
            Image image = ImageIO.read(new File(path + "/resources/Ghost/7.png"));
            this.setImage(image);
            //this.image = ImageIO.read(this.getClass().getResource("resources/Ghost/7.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void nextMoveCalculateByAI(CoreEngine coreEngine){
        Direction direction = this.AI.getMovement(this, coreEngine);
        //System.out.println("movement: " + movementType);
        this.setDirection(direction);
    }
}
