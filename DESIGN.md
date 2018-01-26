Goals:

* Create the Brickout game by generating objects (paddle, bricks, balls, and walls), handling animation, reacting to user input, and computing collisions and effects. 
* Make the game two-player competitive with as little RNG at play as possible, because RNG decreases the importance of skill in the game
* Develop cheat keys and special powers to aid with ball control and debugging. 
* Implement Block using inheritance properties and practice good OOP (Only done in master piece). 
* Allow for easy additions to code in terms of block types (done, but done much better in Masterpiece)

Adding new Features:

* Adding new features is somewhat complex in the original code. 
> Adding Cheat Keys
> - Adding Cheat Keys is relatively simple. Within the HandleKeyInput method, simply add another if statement (for example, if (code = KeyCode.G)) and follow with whatever you want to change in the code. If you wanted to increase the velocity of a ball, for example, you would call myBouncer1.ChangeVel(100). 
> Adding Block Types and special effects
> - This process is somewhat harder, as there is more to keep track of. First, you must assign your new block type a unique ID, one that has not been used yet. Then, in "GenerateBlock" and "brickhit", you must code the specific behavior and parameters of your special block. IF your block needs a new parameter, every block's declaration must also add some version of that parameter. 
> - My masterpiece addresses this difficulty by implementing inheritance. This way, each unique block subclass has a method named "react" that describes the behavior that the block causes in the game, as well as simplifies the process of adding new blocks. Under this new design, simply add your new block type class as an extension of the abstract block, implement "react" however you would like, and add it to the necessary array of potential block types at the beginning of "game".

Major design choices:

* The biggest design choice (and flaw) I made was to ignore good OOP and had blurred lines between main and the classes it called. As a result, object calls and data transfers were cumbersome and inefficient. Furthermore, code became difficult to read and debug, and much more difficult to change or add potential new features. The only benefit to doing it this way is that all the code is not distributed between classes, meaning it can be read continuously. It's not much of a benefit though
* Another design choice was to include the "explosive block", which forced me to implement a 2D map of blocks to preserve positioning. The downside is that it is inefficient to use a 2D array because I couldn't really remove things from the array; every time I checked for collisions I had to check the entire array. A better implementation would be to add a parameter to the explosive block, effectively grouping the surrounding blocks with the explosive block. The problem still remains in terms of obtaining which blocks surround the explosive block, and the potential solution is to use clever math and modulation while generating and adding blocks to the "root" group in the beginning. More detail is provided in the analysis report. 
* Ball is an extension of "circle", adding some useful methods and parameters, dealing mostly with velocity. The implementation in the Masterpeice, however, encapsulates even more functionality into the ball class and reflects better OOP.
* Paddle is an extension of "rectangle", adding only one parameter in velocity. Some methods are added that reflect this new parameter, but they are relatively simple and self-explanatory. 

Assumptions:

The biggest assumption is that the next developer who uses this program will input a 7x7 square matrix and will be fine with the default block layout. Any changes to anything here requires mathematical manipulation and an edit to the parsefile function, which is currently only able to handle square matrices. In addition, there is the assumption that your input file only consists of integers between 1 and 7, anything else is "handled" in that a block will be generated but it has no interaction. Also, this implementation (not the Masterpiece implementation) anticipates few design-level changes; it's not very flexible and adaptable. 
