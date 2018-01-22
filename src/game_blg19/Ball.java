package game_blg19;

import javafx.scene.shape.Circle;

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
