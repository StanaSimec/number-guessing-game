import java.util.Arrays;

enum Difficulty {
    EASY(1, 10),
    MEDIUM(2, 5),
    HARD(3, 3);

    private final int id;
    private final int maxAttempts;

    Difficulty(int id, int maxAttempts) {
        this.id = id;
        this.maxAttempts = maxAttempts;
    }

    static Difficulty fromId(int id) {
        return Arrays.stream(Difficulty.values())
                .filter(d -> d.id == id)
                .findFirst()
                .orElse(null);
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }
}
