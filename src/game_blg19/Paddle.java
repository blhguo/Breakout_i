package game_blg19;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

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
