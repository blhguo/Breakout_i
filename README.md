game
====

First project for CompSci 308 Fall 2017
Extra effects

Direction switch: Both player's controls are reversed
Faster Paddle: Makes the player's paddle faster
Explosive Block: The blocks around the explosive block disappear
P: Pauses player 2's ball
O: Sends player 2's ball towards the top right, allowing player 2 to pull the ball back and save bouncing time
C: Sends player 1's ball in the exact opposite direction.
Regular Block: 1hp block
Sturdy Block: 2hp block
God Block: unbreakable block, unless all other blocks are destroyed
Power-up block: Contains one of the following powerups: Direction switch, Faster Paddle, or Explosive Block.
I: Turns on invincibility
Q: Quits game
1: Adds 1000 points to the next block broken by Player 1
2: Adds 1000 points to the next block broken by Player 2

Under development, not part of project:
Map 4: A map in which the "soft" blocks are almost completely surrounded by God Blocks. Once all "soft" blocks are cleared, the game ends when one player manages to lose their ball. Extensive testing has not been done. See "Level4.txt" for layout

BUGS:
Some of the hit boxes behave strangely. For example, if contact is made with the upper right corner of the block, but the ball's velocity is such that the hitbox registers contact with the top edge of the block, the ball may reflect in a vertical direction. 
