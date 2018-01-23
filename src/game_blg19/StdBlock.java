package game_blg19;

import javafx.scene.shape.Rectangle;



/**
 * @author blg19
 * This class extends the rectangle class to include parameters such as boolean "god", ID, point value, and Exists, as well as methods to retrieve and alter these parameters. 
 *  
 */
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
}
