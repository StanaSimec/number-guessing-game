class Game {
    private final Target target;
    private final int attemptMaxCount;
    private State state;
    private int attemptCount;

    Game(Difficulty difficulty) {
        this.target = new Target();
        this.attemptMaxCount = difficulty.getMaxAttempts();
        state = State.IN_PROGRESS;
    }

    Target.Result attempt(int guessedNumber) {
        if (state != State.IN_PROGRESS) {
            return null;
        }

        Target.Result result = target.attempt(guessedNumber);
        if (result == Target.Result.SHOT) {
            state = State.WIN;
        }

        attemptCount++;
        if (attemptCount >= attemptMaxCount) {
            state = State.LOSE;
        }

        return result;
    }

    boolean isInProgress() {
        return state == State.IN_PROGRESS;
    }

    boolean isWon() {
        return state == State.WIN;
    }

    int attemptsCount() {
        return attemptCount;
    }

    int getTarget() {
        return target.getNumber();
    }

    private enum State {
        IN_PROGRESS,
        WIN,
        LOSE
    }
}
