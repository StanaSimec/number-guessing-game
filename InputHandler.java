import java.util.Scanner;

public class InputHandler {

    void printWelcomeMessage() {
        System.out.print(
                """
                        Welcome to the Number Guessing Game!
                        I'm thinking of a number between 1 and 100.
                        You have 5 chances to guess the correct number.
                        """
        );
    }

    Difficulty getDifficulty() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Please select the difficulty level:
                    1. Easy (10 chances)
                    2. Medium (5 chances)
                    3. Hard (3 chances)
                    """);
            int input;
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input < 1 || input > Difficulty.values().length) {
                    throw new IllegalArgumentException();
                }
                Difficulty difficulty = Difficulty.fromId(input);
                System.out.printf("Great! You selected %s difficulty level.%n", difficulty.name().toLowerCase());
                return difficulty;
            } catch (IllegalArgumentException e) {
                System.out.printf("Please provide option from 1 to %d.%n", Difficulty.values().length);
            }
        }
    }

    int getGuess() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your guess: ");
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input < 0) {
                    throw new IllegalArgumentException();
                }
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("Please provide number bigger than 0.");
            }
        }
    }
}
