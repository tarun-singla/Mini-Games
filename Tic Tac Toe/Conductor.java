public class Conductor {
    public Conductor() {
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("This game has two modes: Two Player[0] and Vs Computer[1]. Else press [2] to exit :(");
        System.out.print("Please choose your mode: ");
    }

    public void ask() {
        System.out.println("\nWant to play again?");
        System.out.print("Choose from Two Player[0], Vs Computer[1] or Exit[2]: ");
    }

    public void wrongInput() {
        System.out.print("\nWrong Input!");
    }

    public void end() {
        System.out.println("\nThank you for playing. Hope you enjoyed!");
    }
}
