package racingcar;

public class Car {
    private Name name;
    private Position position;

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

    public void move(MovingRule movingRule) {
        if (movingRule.movable())
            this.position = new Position(this.position.getValue() + 1);
    }

    public int getPosition() {
        return this.position.getValue();
    }
}
