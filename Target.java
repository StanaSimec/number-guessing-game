import java.util.Random;

class Target {

    private final int number;

    Target() {
        this.number = new Random().nextInt(100) + 1;
    }

    Result attempt(int number) {
        if (this.number == number) return Result.SHOT;
        if (this.number < number) return Result.LOWER;
        return Result.UPPER;
    }

    int getNumber() {
        return number;
    }

    enum Result {
        SHOT,
        LOWER,
        UPPER
    }
}
