package racingcarGame;

public class RoundNumber {
    private int currentRoundNumber;
    private int finalRoundNumber;

    RoundNumber(int number) throws Exception {
        if (number < 1 || number > 10) {
            throw new Exception("시도 회수는 1 이상 10 이하만 가능합니다.");
        }
        this.currentRoundNumber = 0;
        this.finalRoundNumber = number;
    }

    public int upRoundNumber() {
        return currentRoundNumber++;
    }

    public boolean isFinalRound() {
        return currentRoundNumber == finalRoundNumber;
    }

    public boolean isFirstRound() {
        return currentRoundNumber == 0;
    }
}
