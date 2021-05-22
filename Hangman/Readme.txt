This is the game of Hangman!
The player has to guess the word before the sketch of the man is completed!

How to play?
1. Run this program using 'perl Hangman.pl'.

2. The program asks the user whether to play or to exit.
    a) Press 1 to play the game.
    b) Press 0 to exit.
    c) Strictly use above two inputs only. Other inputs may stop the program.
       In case of wrong integer inputs, the program asks the user again for his
       input.

3. The game starts with the instruction that the user has 7 lives.

4. In each turn, the user is asked to make a guess.
    a) The input must be only single letter.
    b) Double or more letter inputs might create problem in the game.
    c) It is suggested that the user gives lower case alphabets as inputs, but
       there is no compulsion.
    d) If the user's guess is correct, then, that letter is replaced everywhere
       in the word.
    e) If the user's guess is wrong, then, a part of the hangman is populated.
       Also, number of lives decreases.
    f) If the user inputs a letter again that has already been used before, the
       program asks the user for input again, but no life will be deducted for it.
    g) Useful information will be printed after every turn.

5. If the user correctly guesses the word before the hangman is completed, the
   user wins. Else, the user loses.

6. At last, the program asks the user again if he wants to play or exit.
   Return to [2].
