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

public class SturdyBlock extends StdBlock {
	public boolean Exists;
	
	public int pVal;
	
	public int ID;
	
	//public int lives;
	
	public SturdyBlock(int xPos, int yPos, int xLength, int yLength, int Points, boolean Exist) {
		super(xPos, yPos, xLength, yLength, Points, Exist);
		this.Exists = Exist;
		this.pVal = Points;
		//this.lives = LifeCount;
		this.ID = 2;
		}
	
//	public void hit() {
//		this.lives = this.lives - 1;
//		if (lives == 0) {
//			this.Exists = false;
//		}
//	}
	
	public void destroy() {
		this.Exists = false;
	}
	
	public int getVal() {
		return this.pVal;
	}
}
