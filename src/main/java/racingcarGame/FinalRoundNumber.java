package racingcarGame;

public class FinalRoundNumber {
    private int finalRoundNumber;

    FinalRoundNumber(int number) throws Exception {
        if (number < 1 || number > 10) {
            throw new Exception("시도 회수는 1 이상 10 이하만 가능합니다.");
        }
        this.finalRoundNumber = number;
    }

    public int getInt() {
        return finalRoundNumber;
    }
}
