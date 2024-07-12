import java.util.Random;
import java.util.Scanner;

public class numgame {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;
        System.out.println("Welcome to the Number Guessing Game!");
        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100. Can you guess it?");
            
            while (!guessedCorrectly && attempts < 10) {
                System.out.print("Enter your guess (1-100): ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly in " + attempts + " attempts.");
                    score += (11 - attempts); // Score calculation
                    guessedCorrectly = true;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you didn't guess the number. The correct number was: " + numberToGuess);
            }
            System.out.print("\nDo you want to play again? (yes/no): ");
            String playChoice = sc.next().toLowerCase();
            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over! Your total score is: " + score);
        sc.close();
    }
}
