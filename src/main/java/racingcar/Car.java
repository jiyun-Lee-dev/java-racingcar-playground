package racingcar;

import java.util.Objects;

public class Car implements Comparable<Car> {
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

    public void move(MovingAction movingAction) {
        if (movingAction.movable())
            this.position = new Position(this.position.getValue() + 1);
    }

    public int getPosition() {
        return this.position.getValue();
    }

    public String getName() {
        return this.name.getValue();
    }

    @Override
    public int compareTo(Car car) {
        return car.getPosition() - getPosition();
    }

    public boolean equalsPosition(Car compared) {
        return compared.getPosition() == getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
