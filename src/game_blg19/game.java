package game_blg19;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
import java.util.*;

public class game extends Application {
    public static final String TITLE = "Two-Player Breakout";
    public static final int SIZE = 800;
    public static final int FRAMES_PER_SECOND = 60;
    public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
    public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    public static final Paint BACKGROUND = Color.AZURE;
    public static final Paint HIGHLIGHT = Color.OLIVEDRAB;    
    //public static final Paint PINK = Color.
    public static final String BOUNCER_IMAGE = "ball.gif";
    public int BOUNCER_SPEED = 30;
    public static final Paint MOVER_COLOR = Color.PLUM;
    public static final int MOVER_LENGTH = 100;
    public static final int MOVER_HEIGHT = 15;
    public int MOVER_SPEED = 50;
    public static final Paint GROWER_COLOR = Color.BISQUE;
    public static final double GROWER_RATE = 1.1;
    public static final int GROWER_SIZE = 50;
    public static final int BALL_RADIUS = 10;
    public static final int BALL_XVEL = 240;
    public static final int BALL_YVEL = -200;
    public static final int BALL_XSTART = 200;
    public static final int BALL_YSTART = 600;
    public static final int BALL_INITIAL_POINTS = 0;
    public static final int BRICK_L = 100;
    public static final int BRICK_W = 20;
    public static final int STDPOINT = 100;
    public static final int STURDYPOINT = 500;
    public static final int PSPOINT = 200;
    public static final int BSPOINT = 200;
    public static final int IPPOINT = 200;
    public static final int GBPOINT = 696969;
    public static final int EBPOINT = 200;
    public static final int XPADDING = 300;
    public static final int YPADDING = 35;
    public Text Score_Text1;
    public int score1;
    public Text Score_Text2;
    public int score2;


    // some things we need to remember during our game
    private Scene myScene;
    //private ImageView myBouncer;
    private Rectangle myMover1, myMover2;
    private Ball myBouncer1, myBouncer2;
    private StdBlock BrickBuffer;
    public Group root = new Group();
    public StdBlock[][] map; //layout of the whole thing, map of blocks
    public Scene splash;
    public String LevelFile;
    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;
    public Stage thestage;

    
    
    /**
     * Initialize what will be displayed and how it will be updated.
     * @throws Exception 
     */
    
    @Override
    public void start (Stage stage) throws Exception {
        // attach scene to the stage and display it
        splash = setupSplash(SIZE, SIZE, BACKGROUND);
    	thestage = stage;
        thestage.setScene(splash);
        thestage.setTitle(TITLE);
        thestage.show();
        // attach "game loop" to timeline to play it

    }
    
    private Scene setupSplash (int width, int height, Paint background) throws Exception {
    	VBox splash = new VBox ();
        //VBox vb = new VBox();
        splash.setPadding(new Insets(10, 50, 50, 50));
        splash.setSpacing(10);

        Label lbl = new Label("BRICKOUT: \n The newest, hippest, swaggiest, poppiest, all-the-kids-are-playing-it-iest game of all time! Following the classic vaporwave aesthetic, the game is simple. \n -Different Blocks have different values. Breaking a block earns you that block's points. \n -The loser is whoever loses their ball first, or whoever scores the fewest points by the time all the blocks are cleared. \n -You only have one life! Spend it wisely (or as the kids say, YOLO) \n -The game only recognizes one input at a time! That means you'd better mash your buttons faster than your opponent! \n -pls dont do anything outside of the intended usecase code is fragile");
        lbl.setFont(Font.font("Amble CN", FontWeight.BOLD, 24));
        splash.getChildren().add(lbl);

        // Buttons
        btn1 = new Button();
        btn1.setText("Map 1");
        btn1.setOnAction(e -> {
			try {
				ButtonClicked(e);
			} catch (Exception e4) {
				// TODO Auto-generated catch block
				e4.printStackTrace();
			}
		});
        splash.getChildren().add(btn1);

        btn2 = new Button();
        btn2.setText("Map 2");
        btn2.setOnAction(e -> {
			try {
				ButtonClicked(e);
			} catch (Exception e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
		});
        splash.getChildren().add(btn2);

        btn3 = new Button();
        btn3.setText("Map 3");
        btn3.setOnAction(e -> {
			try {
				ButtonClicked(e);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
        splash.getChildren().add(btn3);

        btn4 = new Button();
        btn4.setText("Map 4");
        btn4.setOnAction(e -> {
			try {
				ButtonClicked(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        splash.getChildren().add(btn4);

        // Adding VBox to the scene
        Scene scene = new Scene(splash);
        
        return scene;

      }
    
    public void ButtonClicked(ActionEvent e) throws Exception {
    	if (e.getSource()==btn1) {
    		LevelFile = "Resources/Level1.txt";
    	}
    	else if (e.getSource()==btn2) {
    		//System.out.println("oops");
    		LevelFile = "Resources/Level2.txt";
    	}
    	else if (e.getSource()==btn3) {
    		LevelFile = "Resources/Level3.txt";
    	}
    	else if (e.getSource()==btn4) {
    		LevelFile = "Resources/Level4.txt";
    	}
    	
    	myScene = setupGame(SIZE, SIZE, BACKGROUND);
        thestage.setScene(myScene);
        thestage.setTitle(TITLE);
        thestage.show();
    	
        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY),
                e1 -> step(SECOND_DELAY));
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    	
    }
    

    // Create the game's "scene": what shapes will be in the game and their starting properties
    private Scene setupGame (int width, int height, Paint background) throws Exception {
        // create one top level collection to organize the things in the scene
       // Group root = new Group();
        // create a place to see the shapes
        Scene scene = new Scene(root, width, height, background);
        // make some shapes and set their properties
        //Image image = new Image(getClass().getClassLoader().getResourceAsStream(BOUNCER_IMAGE));
        myBouncer1 = new Ball(BALL_XSTART, BALL_YSTART, BALL_RADIUS, -BALL_XVEL, BALL_YVEL, BALL_INITIAL_POINTS);
        myBouncer1.setFill(HIGHLIGHT);
        myBouncer2 = new Ball(width - BALL_XSTART, BALL_YSTART, BALL_RADIUS, BALL_XVEL, BALL_YVEL, BALL_INITIAL_POINTS);
        myBouncer2.setFill(MOVER_COLOR);
        // x and y represent the top left corner, so center it
        //myBouncer.setX(width / 2 - myBouncer.getBoundsInLocal().getWidth() / 2);
        //myBouncer.setY(height / 2 - myBouncer.getBoundsInLocal().getHeight() / 2);
        //myMover = new Rectangle(width / 2 - 25, height / 2 + 100, MOVER_SIZE, 100);
        myMover1 = new Paddle(10, height/2, MOVER_HEIGHT, MOVER_LENGTH, MOVER_SPEED);
        myMover1.setFill(HIGHLIGHT);
        
        myMover2 = new Paddle(width - 10, height/2, MOVER_HEIGHT, MOVER_LENGTH, MOVER_SPEED);
        myMover2.setFill(MOVER_COLOR);
        //myGrower = new Rectangle(width / 2 - 25, height / 2 + 50, GROWER_SIZE, GROWER_SIZE);
        //myGrower.setFill(GROWER_COLOR);
        // order added to the group is the order in which they are drawn

        
        //        *************************** ADD CODE AS A SWITCH FUNCTION TO CHOOSE WHICH MAP/LEVEL
        
        //String LevelFile = "Resources/Level1.txt";
       
       //System.out.println(LevelFile.getName());
        int[][] LevelSet = parsefile(LevelFile);
        map = new StdBlock[LevelSet.length][LevelSet.length];
        
        //System.out.print(levels);
        
        for (int i = 0; i < LevelSet.length; i++) {
        	for (int j = 0; j < LevelSet.length; j++) {
        		int entry = LevelSet[i][j];
        		BrickBuffer = GenerateBlock(entry, i, j);
        		BrickBuffer.setFill(MOVER_COLOR);
        		map[i][j] = BrickBuffer;
        		root.getChildren().add(BrickBuffer);
        }
        }
        
        
        root.getChildren().add(myBouncer1);
        root.getChildren().add(myBouncer2);
        root.getChildren().add(myMover1);
        root.getChildren().add(myMover2);
        
        score1 = myBouncer1.score;
        score2 = myBouncer2.score;
        
        Score_Text1 = new Text(100, 100, "Score: " + score1);
        Score_Text2 = new Text(width - 100, 100, "Score: " + score2);
        root.getChildren().add(Score_Text1);
        root.getChildren().add(Score_Text2);
        //root.getChildren().add(myGrower);
        // respond to input
        scene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
        //scene.setOnMouseClicked(e -> handleMouseInput(e.getX(), e.getY()));
        return scene;
    }

    // Change properties of shapes to animate them 
    // Note, there are more sophisticated ways to animate shapes, but these simple ways work fine to start.
    private void step (double elapsedTime) {
        	//root.getChildren().add(Score_Text1);
        	//root.getChildren().add(Score_Text2);
//        // update attributes
          myBouncer1.setCenterX((myBouncer1.getCenterX() + myBouncer1.xVel * elapsedTime));
          myBouncer1.setCenterY((myBouncer1.getCenterY() + myBouncer1.yVel * elapsedTime));
          myBouncer2.setCenterX((myBouncer2.getCenterX() + myBouncer2.xVel * elapsedTime));
          myBouncer2.setCenterY((myBouncer2.getCenterY() + myBouncer2.yVel * elapsedTime));
    	  //myMover.setRotate(myMover.getRotate());
//        myGrower.setRotate(myGrower.getRotate() + 1);
//
        if (((myBouncer1.getCenterY()) + BALL_RADIUS) >= SIZE || myBouncer1.getCenterY() - BALL_RADIUS <= 0) {
        	myBouncer1.yVel = -1 * myBouncer1.yVel;
        }
        if (myBouncer1.getCenterX() + BALL_RADIUS >= SIZE) {
        	myBouncer1.xVel = -1 * myBouncer1.xVel;
        }
        
        if (myBouncer1.getCenterX() > SIZE || myBouncer2.getCenterX() < 0) {
        	//end game here
        }
        
        if (((myBouncer2.getCenterY()) + BALL_RADIUS) >= SIZE || myBouncer2.getCenterY() - BALL_RADIUS <= 0) {
        	myBouncer2.yVel = -1 * myBouncer2.yVel;
        }
        if (myBouncer2.getCenterX() - BALL_RADIUS <= 0) {
        	myBouncer2.xVel = -1 * myBouncer2.xVel;
        }
//        
//        // check for collisions
//        // with shapes, can check precisely
        Shape intersect = Shape.intersect(myMover1, myBouncer1);
        if (intersect.getBoundsInLocal().getWidth() != -1) {
            myBouncer1.xVel = -1*myBouncer1.xVel;
        }
        else {
            myMover1.setFill(HIGHLIGHT);
        }
        
        Shape intersect1 = Shape.intersect(myMover2, myBouncer2);
        if (intersect1.getBoundsInLocal().getWidth() != -1) {
            myBouncer2.xVel = -1*myBouncer2.xVel;
        }
        else {
            myMover2.setFill(MOVER_COLOR);
        }
        
        BrickCollide(myBouncer1);
        BrickCollide(myBouncer2);
        
        
//        // with images can only check bounding box
//        if (myGrower.getBoundsInParent().intersects(myBouncer.getBoundsInParent())) {
//            myGrower.setFill(HIGHLIGHT);
//        }
//        else {
//            myGrower.setFill(GROWER_COLOR);
//        }
        
        //if ()
        
    }

    // What to do each time a key is pressed
    private void handleKeyInput (KeyCode code) {
        if (code == KeyCode.DOWN) {
            myMover1.setY(myMover1.getY() + MOVER_SPEED);
        }
        else if (code == KeyCode.UP) {
            myMover1.setY(myMover1.getY() - MOVER_SPEED);
        }
        if (code == KeyCode.S) {
            myMover2.setY(myMover2.getY() + MOVER_SPEED);
        }
        else if (code == KeyCode.W) {
            myMover2.setY(myMover2.getY() - MOVER_SPEED);
        }
    }
    
    private void BrickCollide(Ball B) {
    	//System.out.println(map.toString());
    	for (int i = 0; i < map.length; i++) {
    		for (int j = 0; j < map.length; j++) {
   	        Shape intersect1 = Shape.intersect(map[i][j], B);
    	        if (intersect1.getBoundsInLocal().getWidth() != -1) {
   	        	if (( map[i][j].Exists == true && (B.getCenterX() > map[i][j].getX() - BALL_RADIUS || (B.getCenterX() < (map[i][j].getX() + BRICK_W + BALL_RADIUS))))) {
    	        	
   	        		B.xVel = -1*B.xVel;
    	        		brickhit(map[i][j], B, i, j);
    	        		//map[i][j].destroy();
    	        		score1 = myBouncer1.score;
    	        		score2 = myBouncer2.score;
    	                Score_Text1.setText("Score: " + score1);
    	                Score_Text2.setText("Score: " + score2);
    	        	}
   	        	
    	        	if  (map[i][j].Exists == true && ((B.getCenterY() > map[i][j].getY() - BALL_RADIUS) ||  (B.getCenterY() < map[i][j].getY() + BRICK_L + BALL_RADIUS))) {
    	        		B.yVel = -1*B.yVel;
    	        		brickhit(map[i][j], B, i, j);
    	        		//map[i][j].destroy();
    	        		score1 = myBouncer1.score;
    	        		score2 = myBouncer2.score;
    	                Score_Text1.setText("Score: " + score1);
    	                Score_Text2.setText("Score: " + score2);
    	        		
    	        	}
    	        	}
    	        else {
    	            myMover2.setFill(MOVER_COLOR);
    	        }
    	        
    		}
    	}
    	
    	if (root.getChildren().size() == 4) {
    		//declare winner
    	}
    }
    
    public void brickhit(StdBlock S, Ball B, int i, int j) {
    	System.out.println(S.ID);
    	System.out.println(B.score);
    	//System.out.println(STDPOINT);
    	switch (S.ID) {
    		case 1: 
    			//System.out.println("Execute 1");
    			root.getChildren().remove(S); 
    			B.score = B.score + STDPOINT;
    			map[i][j].destroy();
    			break;
    		case 2:
    			//System.out.println("execute2");
    			S.ID = 1; 
    			B.score = B.score + STDPOINT;
    			break;
    		case 3:
    			MOVER_SPEED = MOVER_SPEED * 2; 
    			root.getChildren().remove(S); 
    			B.score = B.score + PSPOINT;
    			map[i][j].destroy();
    			break;
    		case 4:
    			B.ChangeXVel(BALL_XVEL);
    			B.ChangeYVel(BALL_YVEL);
    			root.getChildren().remove(S);
    			B.score = B.score + BSPOINT;
    			map[i][j].destroy();
    			break;
    		case 5:
    			//System.out.println("Here");
    			MOVER_SPEED = -1 * MOVER_SPEED; 
    			root.getChildren().remove(S); 
    			B.score = B.score + IPPOINT;
    			map[i][j].destroy();
    			break;
    		case 6:
    			if (root.getChildren().size() == 5) {
    				root.getChildren().remove(S);
    				map[i][j].destroy();
    				B.score = B.score + GBPOINT;
    			}
    			break;
    		case 7:
    		//System.out.println("executed");
    		root.getChildren().remove(S);
    		B.score = B.score + EBPOINT;
    		if (j < 6) {
    			if (root.getChildren().contains(map[i][j+1])) {
    				root.getChildren().remove(map[i][j+1]); map[i][j+1].destroy();
    				}
    			}
    		if (j > 0) {
    			if (root.getChildren().contains(map[i][j-1])) {
    				root.getChildren().remove(map[i][j-1]); map[i][j-1].destroy();
    				}
    			}
    		if (i < 6) {
    			if (root.getChildren().contains(map[i+1][j])) {
    				root.getChildren().remove(map[i+1][j]); map[i+1][j].destroy();
    				}
    			}
    		if (i < 0) {
    			if (root.getChildren().contains(map[i-1][j])) {
    				root.getChildren().remove(map[i-1][j]); map[i-1][j].destroy();
    				}
    			}
    		map[i][j].destroy();
    		break;
    	}
    	//System.out.println(B.score);
    }
    
    public StdBlock GenerateBlock(int Identity, int xpos, int ypos) {
    	
    	switch (Identity) {
    		case 1: return new StdBlock((BRICK_W * xpos + 10 * (xpos + 1) + XPADDING), (BRICK_L * ypos + 5 * (ypos + 1) + YPADDING), BRICK_W, BRICK_L, STDPOINT, 1, false, true);
//    		case 2: return new SturdyBlock((BRICK_L * xpos + 10 * (xpos + 1)), (BRICK_W * ypos + 5 * (ypos + 1)), BRICK_L, BRICK_W, STURDYPOINT, true, 2);
//    		case 3: return new PSBlock((BRICK_L * xpos + 10 * (xpos + 1)), (BRICK_W * ypos + 5 * (ypos + 1)), BRICK_L, BRICK_W, PSPOINT, true);
//    		case 4: return new BSBlock((BRICK_L * xpos + 10 * (xpos + 1)), (BRICK_W * ypos + 5 * (ypos + 1)), BRICK_L, BRICK_W, BSPOINT, true);
//    		case 5: return new IPBlock((BRICK_L * xpos + 10 * (xpos + 1)), (BRICK_W * ypos + 5 * (ypos + 1)), BRICK_L, BRICK_W, IPPOINT, true);
//    		case 6: return new GodBlock((BRICK_L * xpos + 10 * (xpos + 1)), (BRICK_W * ypos + 5 * (ypos + 1)), BRICK_L, BRICK_W, GBPOINT, true, false);
    		case 2: return new StdBlock((BRICK_W * xpos + 10 * (xpos + 1) + XPADDING), (BRICK_L * ypos + 5 * (ypos + 1) + YPADDING), BRICK_W, BRICK_L, STDPOINT, 2, false, true);
    		case 3: return new StdBlock((BRICK_W * xpos + 10 * (xpos + 1) + XPADDING), (BRICK_L * ypos + 5 * (ypos + 1) + YPADDING), BRICK_W, BRICK_L, STDPOINT, 3, false, true);
    		case 4: return new StdBlock((BRICK_W * xpos + 10 * (xpos + 1) + XPADDING), (BRICK_L * ypos + 5 * (ypos + 1) + YPADDING), BRICK_W, BRICK_L, STDPOINT, 4, false, true);
    		case 5: return new StdBlock((BRICK_W * xpos + 10 * (xpos + 1) + XPADDING), (BRICK_L * ypos + 5 * (ypos + 1) + YPADDING), BRICK_W, BRICK_L, STDPOINT, 5, false, true);
    		case 6: return new StdBlock((BRICK_W * xpos + 10 * (xpos + 1) + XPADDING), (BRICK_L * ypos + 5 * (ypos + 1) + YPADDING), BRICK_W, BRICK_L, STDPOINT, 6, true, true);
    		case 7: return new StdBlock((BRICK_W * xpos + 10 * (xpos + 1) + XPADDING), (BRICK_L * ypos + 5 * (ypos + 1) + YPADDING), BRICK_W, BRICK_L, STDPOINT, 7, false, true);
    		
    	}
    	
    	 return new StdBlock((BRICK_L * xpos + 10 * (xpos + 1)), (BRICK_W * ypos + 5 * (ypos + 1)), BRICK_L, BRICK_W, STDPOINT, 0, false, true);
    }
    
    public static int[][] parsefile(String filename) throws Exception {
    	int[][] level = null;
    	
    	BufferedReader buffer = new BufferedReader(new FileReader(filename));
    	String line;
    	int row = 0;
    	int size = 0;
    	while ((line = buffer.readLine()) != null) {
    		String[] vals = line.trim().split("\\s+");
    		if (level == null) {
    			size = vals.length;
    			//currently only designed to take in square matrices, please pad your map with zeros
    			level = new int[size][size];
    		}
    		
    		for (int col = 0; col < size; col++) {
    			level[row][col] = Integer.parseInt(vals[col]);
    		}
    		
    		row++;
    	}
    	//System.out.print(level);
    			return level;
    }
    
//    public static int[][] parsefile() throws Exception {
//    	int[][] rows = null;
//    	try {
//			Scanner scan = new Scanner(new File("levels"));
//			System.out.print("potato");
//			int index = 0;
//			//char[][] rows = null;
//			//int[][] matrix = null;
//			while (scan.hasNextLine()) {
//				String line = scan.nextLine();
//				if (!line.equals("")) {
//					line = line.replaceAll(",", "");
//					line = line.replaceAll(" ", "");
//					rows[index] = s2i(line.toString());
//					index++;
//				}
//			}
//			scan.close();
//			//return rows;
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//    	//System.out.print("potato");
//    	System.out.print(rows);
//    	return rows;
//    	
//    }
    
//    public static int[] s2i(String ints) {
//    	
//    int[] intArray = new int[ints.length()];
//
//    for (int i = 0; i < ints.length(); i++) {
//    	intArray[i] = Character.digit(ints.charAt(i), 10);
//    }
//    
//    return intArray;
//    }
    
    public void endgame() {
    	
    }
    

    /**
     * Start the program.
     */
    public static void main (String[] args) {
        launch(args);
    }
}
