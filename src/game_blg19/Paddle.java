package game_blg19;

import javafx.scene.shape.Rectangle;

/**
 * @author blg19
 * This class extends Rectangle to include parameters such as velocity and methods to alter the parameters. In this case xVel actually represents yVelocity
 */
public class Paddle extends Rectangle{
    public int xVel;
    //public int yVel;
    public Paddle(int xPos, int yPos, int xLength, int yLength, int Velocity) {
    	super(xPos, yPos, xLength, yLength);
    	this.xVel = Velocity;
    	//this.yVel = yVel;
    }
    
    public void ChangeVel(int accelerate) {
    	this.xVel = this.xVel + accelerate;
    }
    
    public void ChangeDir() {
    	this.xVel = -1*this.xVel;
    }
}
