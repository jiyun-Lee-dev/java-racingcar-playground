package racingcarGame;

public enum CarStatus {
    PASS, FAIL;

    public static boolean isPass(CarStatus carStatus) {
        return carStatus == PASS;
    }
}
