import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the random number guessing game!");
        System.out.println("""
                In this game, you will enter a range of numbers (minimum and maximum).
                The program will generate a random number within that range, and you have to guess it.
                After each guess, you will be told if your guess is too high, too low, or correct.
                Keep guessing until you find the correct number!
                """);

        Scanner sc = new Scanner(System.in);

        int min = 0;
        int max = 0;
        boolean validRange = false;

        // Get valid range from user
        while (!validRange) {
            min = getValidNumber(sc, "Enter a minimum number (Integer): ");
            max = getValidNumber(sc, "Enter a maximum number (Integer): ");

            if (max < min) {
                System.out.println("Maximum number is lower than minimum number. Please enter the numbers again.");
            } else {
                validRange = true;
            }
        }

        int guesses = 0;
        int randomNr = getRandomNumber(min, max);

        System.out.println("Pick a random integer number between " + min + " and " + max);

        // Main game loop
        while (true) {
            int guess = getValidNumber(sc, "Enter your guess: ");
            guesses++;

            if (guess < min || guess > max) {
                System.out.println("Guess out of range. Please enter a number between " + min + " and " + max);
            } else if (guess < randomNr) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNr) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number " + randomNr + " in " + guesses + " attempts.");
                break;
            }
        }

        sc.close();
    }

    // Method to get a valid integer from the user
    public static int getValidNumber(Scanner sc, String prompt) {
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println(prompt);
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next();
            }
        }

        return number;
    }

    // Method to generate a random number between min (inclusive) and max (inclusive)
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
