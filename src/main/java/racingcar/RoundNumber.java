package racingcar;

public class RoundNumber {
    private final int finalRound;
    private int currentRound;

    public RoundNumber(int number) throws Exception {
        if (number < 1 || number > 5) {
            throw new IllegalArgumentException("시도회수는 최대 5까지만 가능합니다.");
        }
        finalRound = number;
        currentRound = 0;
    }

    public void next() {
        this.currentRound++;
    }

    public boolean isFinal() {
        return currentRound == finalRound;
    }

    public boolean isMoreThanFinal() {
        return currentRound > finalRound;
    }
}
