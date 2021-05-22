import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Conductor conductor = new Conductor();

        Scanner scanner = new Scanner(System.in);
        int version = scanner.nextInt();

        while(version != 2) {
            if(version == 0) {
                TwoPlayer game = new TwoPlayer();
                game.playGame();
            }
            else if(version == 1) {
                PlayerVsComputer game = new PlayerVsComputer();
                game.playGame();
            }
            else {
                conductor.wrongInput();
            }

            conductor.ask();
            version = scanner.nextInt();
        }

        scanner.close();
        conductor.end();
    }
}
