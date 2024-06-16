import java.util.Scanner;
import java.util.Random;

public class onePlayer {

    private static final String[] MOVES = {"rock", "paper", "scissors"};

    public static void main(String[] args) {
        System.out.println("""
        Welcome to the Rock, Paper, Scissors game!

        This is a classic game where you will compete against the computer.
        You will choose between Rock, Paper, or Scissors, and the computer
        will randomly select its move.

        Rules:
        - Rock beats Scissors
        - Scissors beat Paper
        - Paper beats Rock

        Can you outsmart the computer? Let's find out!
        """);

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        while (playAgain) {
            String playerMove = getPlayerMove(sc);

            int computerMoveIndex = random.nextInt(MOVES.length);
            String computerMove = MOVES[computerMoveIndex];

            System.out.println("Computer chose: " + computerMove);

            whoWins(playerMove, computerMove);

            playAgain = askPlayAgain(sc);
        }

    }

    private static String getPlayerMove(Scanner sc) {
        String move;
        while (true) {
            System.out.print("Player, enter your move (Rock, Paper or Scissors): ");
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

    private static void whoWins(String player1Move, String computerMove) {
        if (player1Move.equals(computerMove)) {
            System.out.println("It's a tie!");
        } else if ((player1Move.equals("rock") && computerMove.equals("scissors")) ||
                (player1Move.equals("scissors") && computerMove.equals("paper")) ||
                (player1Move.equals("paper") && computerMove.equals("rock"))) {
            System.out.println("You win!");
        } else {
            System.out.println("Computer wins!");
        }
    }

    private static boolean askPlayAgain(Scanner sc) {
        while (true) {
            System.out.println("");
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
