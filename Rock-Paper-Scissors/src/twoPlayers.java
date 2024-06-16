import java.util.Scanner;

public class twoPlayers {
    public static void main(String[] args) {
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("""
                This is a two-player game.
                Each player will enter their move (Rock, Paper, or Scissors) in turn.
                Rules:
                - Rock beats Scissors
                - Scissors beat Paper
                - Paper beats Rock
                """);


        Scanner sc = new Scanner(System.in);

        boolean playAgain = true;
        while (playAgain) {
            String player1Move = getPlayerMove(sc, 1);
            String player2Move = getPlayerMove(sc, 2);

            whoWins(player1Move, player2Move);

            playAgain = askPlayAgain(sc);
        }

    }

    private static String getPlayerMove(Scanner sc, int playerNumber) {
        String move;
        while (true) {
            System.out.print("Player " + playerNumber + ", enter your move (Rock, Paper or Scissors): ");
            move = sc.nextLine().trim().toLowerCase();
            if (isValidMove(move)) {
                break;
            } else {
                System.out.println("Invalid input. Please enter Rock, Paper or Scissors.");
            }
        }
        return move;
    }

    private static boolean isValidMove(String move) {
        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
    }

    private static void whoWins(String player1Move, String player2Move) {
        if (player1Move.equals(player2Move)) {
            System.out.println("It's a tie!");
        } else if ((player1Move.equals("rock") && player2Move.equals("scissors")) ||
                (player1Move.equals("scissors") && player2Move.equals("paper")) ||
                (player1Move.equals("paper") && player2Move.equals("rock"))) {
            System.out.println("Player 1 wins!");
        } else {
            System.out.println("Player 2 wins!");
        }
    }

    private static boolean askPlayAgain(Scanner sc) {
        while (true) {
            System.out.print("Do you want to play again? (yes/no): ");
            String response = sc.nextLine().trim().toLowerCase();
            if (response.equals("yes")) {
                return true;
            } else if (response.equals("no")) {
                System.out.println("The game will now close.");
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }
}
