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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Ball extends Circle {
	public int xVel;
	public int yVel;
	public int score;
	public Ball(int xPos, int yPos, int radius, int xVelocity, int yVelocity, int points) {
		super(xPos, yPos, radius);
		this.xVel = xVelocity;
		this.yVel = yVelocity;
		this.score = points;
	}
	public void ChangeXVel(int accel) {
		this.xVel = this.xVel + accel;
	}
	
	public void ChangeYVel(int accel) {
		this.yVel = this.yVel + accel;
	}
	
	public void UpdateScore(int point) {
		this.score = this.score + point;
	}
}
