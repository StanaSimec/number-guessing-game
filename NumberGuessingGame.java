public class NumberGuessingGame {

    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        inputHandler.printWelcomeMessage();
        Difficulty difficulty = inputHandler.getDifficulty();
        Game game = new Game(difficulty);
        while (game.isInProgress()) {
            int guess = inputHandler.getGuess();
            Target.Result result = game.attempt(guess);
            if (game.isWon()) {
                System.out.printf("Congratulations! You guessed the correct number in %d attempts.%n", game.attemptsCount());
                return;
            }
            System.out.printf("Incorrect! The number is %s than %d%n", result.toString().toLowerCase(), guess);
        }
        System.out.printf("You loose. The mystery number is %d%n", game.getTarget());
    }
}
