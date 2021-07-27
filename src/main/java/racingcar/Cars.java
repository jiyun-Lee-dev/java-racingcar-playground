package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Name> names) throws Exception {
        if (names.size() <= 1) {
            throw new IllegalArgumentException("자동차는 최소 1개 이상이어야 합니다.");
        }

        List<Car> cars = new ArrayList<>();
        for (Name name : names) {
            cars.add(new Car(name, new Position(0)));
        }
        this.cars = cars;
    }

    public void move(List<MovingAction> movingActions) {
        int index = 0;
        for(MovingAction action : movingActions) {
            cars.get(index).move(action);
            index++;
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        Collections.sort(cars);
        Car firstWinner = cars.get(0);

        winners.add(firstWinner);
        winners.addAll(cars.stream()
                .filter(car -> car.equalsPosition(firstWinner) && !car.equals(firstWinner))
                .collect(Collectors.toList()));

        return winners;
    }

    public LinkedHashMap<String, Integer> getCarsData() {
        LinkedHashMap<String, Integer> data = new LinkedHashMap<String, Integer>();
        for (Car car : cars) {
            data.put(car.getName(), car.getPosition());
        }
        return data;
    }

    public int getSize() {
        return cars.size();
    }
}
