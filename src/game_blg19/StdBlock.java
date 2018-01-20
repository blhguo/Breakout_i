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

public class StdBlock extends Rectangle {
	public boolean God;
	
	public int ID;
	
	public int pVal;
	
	public boolean Exists;
	
	public StdBlock(int xPos, int yPos, int xLength, int yLength, int Points, int ID, boolean invincible, boolean Exist) {
		super(xPos, yPos, xLength, yLength);
		this.God = invincible;
		this.pVal = Points;
		this.ID = ID;
		this.Exists = Exist;
		}
	
	public void destroy() {
		this.Exists = false;
	}
	
	public int getVal() {
		return this.pVal;
	}
}
