package racingcarGame;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) throws Exception {
        List<Car> cars = makeCars(carNames);
        if (validateCarsNumber(cars)) {
            throw new Exception("자동차는 2개 이상, 5개 이하로 생성할 수 있습니다.");
        }
        this.cars = cars;
    }

    private List<Car> makeCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }

    private boolean validateCarsNumber(List<Car> cars){
        return cars.size() < 2 || cars.size() > 5;
    }

    public int getSize() {
        return cars.size();
    }

    public void moveCars(List<Integer> randomNumbers) throws Exception {
        if (randomNumbers.size() != getSize()) {
            throw new Exception("시스템 오류가 발생했습니다.");
        }
        int index = 0;
        for (int randomNumber : randomNumbers) {
            cars.get(index).move(randomNumber);
            index++;
        }
    }

    public List<String> getWinners() {
        List<String> winners;
        Car carWithMaxDist = cars.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .orElseThrow(NoSuchElementException::new);

        int maxDist = carWithMaxDist.getLocation();
        winners = cars.stream()
                .filter(car -> {
                    return car.getLocation() == maxDist;
                })
                .map(Car::getName)
                .collect(Collectors.toList());

        return winners;
    }

    public LinkedHashMap<String, Integer> getAllCarsData() {
        LinkedHashMap<String, Integer> data = new LinkedHashMap<String, Integer>();
        for (Car car : cars) {
            data.put(car.getName(), car.getLocation());
        }
        return data;
    }
}
