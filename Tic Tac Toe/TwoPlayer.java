import java.util.Scanner;

public class TwoPlayer {
    //a is board
    private char[] a = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    private Scanner sc = new Scanner(System.in);

    public TwoPlayer() {
        System.out.println("\nYou have chosen Two Player mode. Player 1 is [X] and Player 2 is [O].");
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("---|---|---");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("---|---|---");
        System.out.println(" 7 | 8 | 9 ");
    }

    private void printBoard() {
        System.out.printf(" %s | %s | %s \n", a[0], a[1], a[2]);
        System.out.println("---|---|---");
        System.out.printf(" %s | %s | %s \n", a[3], a[4], a[5]);
        System.out.println("---|---|---");
        System.out.printf(" %s | %s | %s \n", a[6], a[7], a[8]);
    }

    private boolean checkWin() {
        if(a[0] == a[1] && a[1] == a[2] && a[0] != ' ') {
            return true;
        }
        else if(a[3] == a[4] && a[4] == a[5] && a[3] != ' ') {
            return true;
        }
        else if(a[6] == a[7] && a[7] == a[8] && a[6] != ' ') {
            return true;
        }
        else if(a[0] == a[3] && a[3] == a[6] && a[0] != ' ') {
            return true;
        }
        else if(a[1] == a[4] && a[4] == a[7] && a[1] != ' ') {
            return true;
        }
        else if(a[2] == a[5] && a[5] == a[8] && a[2] != ' ') {
            return true;
        }
        else if(a[0] == a[4] && a[4] == a[8] && a[0] != ' ') {
            return true;
        }
        else if(a[2] == a[4] && a[4] == a[6] && a[2] != ' ') {
            return true;
        }
        else {
            return false;
        }
    }

    private void takeInput(int player) {
        System.out.printf("Player %d choose one of the following: ", player % 2 + 1);
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

        if(player % 2 == 0) {
            a[temp] = 'X';
        }
        else {
            a[temp] = 'O';
        }
    }

    public void playGame() {
        int i;
        for(i = 0; i < 9; i++) {
            takeInput(i);
            printBoard();
            if(checkWin()) {
                break;
            }
        }

        if(i == 9) {
            System.out.println("Draw!");
        }
        else if(i % 2 == 0) {
            System.out.printf("Player %d won!\n", i % 2 + 1);
        }
        else {
            System.out.printf("Player %d won!\n", i % 2 + 1);
        }
    }
}
