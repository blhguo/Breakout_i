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

public class BSBlock extends Rectangle {
	public boolean Exists;
	
	public int pVal;
	
	public int ID;
	
	public BSBlock(int xPos, int yPos, int xLength, int yLength, int Points, boolean Exist) {
		super(xPos, yPos, xLength, yLength);
		this.Exists = Exist;
		this.pVal = Points;
		this.ID = 4;
		}
	
	public void destroy() {
		this.Exists = false;
	}
	
	public int getVal() {
		return this.pVal;
	}
}
