package racingcarGame;

public class RandomNumberGenerator {
    private int randomNumber;

    RandomNumberGenerator() {
        this.randomNumber = generateNumber();
    }

    private int generateNumber() {
        return (int)(Math.random() * 10);
    }

    public int getRandomNumber() {
        return this.randomNumber;
    }
}
