This is the game of Tic Tac Toe.
It has two modes: Two Player and Player vs Computer

//How to Play?
1. Start this game using the command 'java TicTacToe'

2. The program first asks the user about the mode. The input must be an integer as follows:
    a) 0 for Two Player mode.
    b) 1 for Player vs Computer mode.
    c) 2 to exit.

3. Two Player Mode:
    a) Player 1 moves first.
    b) The program asks each player alternatively about their choices.
    c) The input must be an integer between 1-9.
    d) The players must choose a position which is not filled already.

4. Player vs Computer Mode:
    a) The player will move first.
    b) After that the program asks the player to move after making its move.
    c) The input must be an integer between 1-9.
    d) The player must choose a position which is not filled already.

5. After one game, the program again asks the user for a new game or to exit.

//Some points
1. If the user gives a wrong integer input, then, the program asks the user
    again for his choice. This goes for both invalid input or input for already
    filled positions.
2. The inputs can only be integers. Other inputs may stop the program.
