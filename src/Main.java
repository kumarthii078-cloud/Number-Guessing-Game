import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalGames = 0;
        int gamesWon = 0;
        int gamesLost = 0;

        String playAgain;

        System.out.println("==============================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("==============================");

        do {

            System.out.println("\nSelect Difficulty:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            int maxNumber = 100;
            int maxAttempts = 7;

            switch (choice) {

                case 1:
                    maxNumber = 50;
                    maxAttempts = 10;
                    System.out.println("Easy Mode Selected!");
                    break;

                case 2:
                    maxNumber = 100;
                    maxAttempts = 7;
                    System.out.println("Medium Mode Selected!");
                    break;

                case 3:
                    maxNumber = 200;
                    maxAttempts = 5;
                    System.out.println("Hard Mode Selected!");
                    break;

                default:
                    System.out.println("Invalid choice!");
                    sc.close();
                    return;
            }

            int secretNumber = random.nextInt(maxNumber) + 1;

            int attempts = 0;
            boolean won = false;

            System.out.println("\nGuess a number between 1 and "
                    + maxNumber);

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");

                int guess = sc.nextInt();

                attempts++;

                if (guess > secretNumber) {

                    System.out.println("Too High!");

                } else if (guess < secretNumber) {

                    System.out.println("Too Low!");

                } else {

                    System.out.println("Correct! You Win!");
                    won = true;
                    break;
                }

                System.out.println("Attempts used: " + attempts);

                System.out.println("Attempts remaining: "
                        + (maxAttempts - attempts));
            }

            totalGames++;

            if (won) {

                gamesWon++;

                System.out.println("\nCongratulations!");

            } else {

                gamesLost++;

                System.out.println("\nGame Over!");
                System.out.println("Correct number was: "
                        + secretNumber);
            }

            System.out.println("Round " + totalGames
                    + " - guessed in " + attempts + " attempts");

            System.out.print("\nDo you want to play again? (yes/no): ");

            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n==============================");
        System.out.println("       FINAL SCORE");
        System.out.println("==============================");

        System.out.println("Total Games: " + totalGames);
        System.out.println("Games Won: " + gamesWon);
        System.out.println("Games Lost: " + gamesLost);

        System.out.println("\nThank you for playing!");

        sc.close();
    }
}