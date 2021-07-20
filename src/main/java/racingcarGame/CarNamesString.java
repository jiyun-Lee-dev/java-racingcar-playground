package racingcarGame;

public class CarNamesString {
    private String carNames;

    CarNamesString(String carNames) throws Exception {
        if (carNames.isEmpty()) {
            throw new Exception("빈 문자열 또는 null 값을 입력했습니다. 시스템을 종료합니다.");
        }
        this.carNames = carNames;
    }

    public String getString() {
        return carNames;
    }
}
