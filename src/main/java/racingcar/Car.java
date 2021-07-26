package racingcar;

public class Car {
    private final Name name;
    private final Position position;

    public Car(Name name, Position position) throws Exception {
        if (isTooLong(name)) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    private boolean isTooLong(Name name) {
        return name.getLength() > 5;
    }
}
