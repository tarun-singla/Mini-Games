import java.util.Scanner;

public class PlayerVsComputer {

    private Scanner sc = new Scanner(System.in);

    public PlayerVsComputer() {
        System.out.println("\nYou have chosen Vs Computer mode. Player is [X] and Computer is [O].");
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("---|---|---");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("---|---|---");
        System.out.println(" 7 | 8 | 9 ");
    }

    private void printBoard(char a[]) {
        System.out.printf(" %s | %s | %s \n", a[0], a[1], a[2]);
        System.out.println("---|---|---");
        System.out.printf(" %s | %s | %s \n", a[3], a[4], a[5]);
        System.out.println("---|---|---");
        System.out.printf(" %s | %s | %s \n", a[6], a[7], a[8]);
    }

    private int checkWin(char a[]) {
        if(a[0] == a[1] && a[1] == a[2] && a[0] != ' ') {
            return 1;
        }
        else if(a[3] == a[4] && a[4] == a[5] && a[3] != ' ') {
            return 3;
        }
        else if(a[6] == a[7] && a[7] == a[8] && a[6] != ' ') {
            return 6;
        }
        else if(a[0] == a[3] && a[3] == a[6] && a[0] != ' ') {
            return 3;
        }
        else if(a[1] == a[4] && a[4] == a[7] && a[1] != ' ') {
            return 1;
        }
        else if(a[2] == a[5] && a[5] == a[8] && a[2] != ' ') {
            return 2;
        }
        else if(a[0] == a[4] && a[4] == a[8] && a[0] != ' ') {
            return 4;
        }
        else if(a[2] == a[4] && a[4] == a[6] && a[2] != ' ') {
            return 2;
        }
        else {
            return 0;
        }
    }

    private int takeInput(char a[]) {
        System.out.print("Choose one of the following: ");
        int temp = sc.nextInt() - 1;

        while(true) {
            if(temp < 0 || temp > 8) {
                System.out.print("Wrong Input. Please choose another: ");
                temp = sc.nextInt() - 1;
            }
            else if(a[temp] == 'X' || a[temp] == 'O') {
                System.out.print("This is already filled. Please choose another: ");
                temp = sc.nextInt() - 1;
            }
            else {
                break;
            }
        }

        return temp;
    }

/******************************************************************************/
    private boolean ifMoves(char a[]) {
        for(int i = 0; i < 9; i++) {
            if(a[i] == ' ') {
                return true;
            }
        }

        return false;
    }

    private int getScore(char a[]) {
        int p = checkWin(a);
        if(p == 0) {
            return 0;
        }
        else if(a[p] == 'O') {
            return 10;
        }
        else {
            return -10;
        }
    }

    private int mainAlgorithm(char a[], boolean isComputer, int depth) {
        int score = getScore(a);

        if(score == 10) {
            return score - depth;
        }
        if(score == -10) {
            return score + depth;
        }
        if(!ifMoves(a)) {
            return 0;
        }

        if(isComputer) {
            int maxScore = -1000;
            for(int i = 0; i < 9; i++) {
                if(a[i] == ' ') {
                    a[i] = 'O';
                    maxScore = Math.max(maxScore, mainAlgorithm(a, !isComputer, depth + 1));
                    a[i] = ' ';
                }
            }
            return maxScore;
        }
        else {
            int minScore = 1000;
            for(int i = 0; i < 9; i++) {
                if(a[i] == ' ') {
                    a[i] = 'X';
                    minScore = Math.min(minScore, mainAlgorithm(a, !isComputer, depth + 1));
                    a[i] = ' ';
                }
            }
            return minScore;
        }
    }

    private int playComputer(char a[]) {
        int move = -1, score = -1000;

        for(int i = 0; i < 9; i++) {
            if(a[i] == ' ') {
                a[i] = 'O';
                int temp = mainAlgorithm(a, false, 0);
                a[i] = ' ';

                if(temp > score) {
                    score = temp;
                    move = i;
                }
            }
        }

        System.out.printf("Computer chose %d.\n", move + 1);
        return move;
    }
/******************************************************************************/
    public void playGame() {
        //a is board
        char[] a = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        int i;
        for(i = 0; i < 9; i++) {
            if(i % 2 == 0) {
                int temp = takeInput(a);
                a[temp] = 'X';
            }
            else {
                int temp = playComputer(a);
                a[temp] = 'O';
            }
            printBoard(a);
            int win = checkWin(a);
            if(win > 0) {
                break;
            }
        }

        if(i == 9) {
            System.out.println("Draw!");
        }
        else if(i % 2 == 0) {
            System.out.println("Congratulations! You won.");
        }
        else {
            System.out.println("Computer won!");
        }
    }
}
