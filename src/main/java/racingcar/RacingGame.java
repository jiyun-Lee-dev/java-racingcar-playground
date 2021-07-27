package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final RoundNumber roundNumber;

    public RacingGame(String nameString, int roundNumber) throws Exception {
        this.cars = makeCars(nameString);
        this.roundNumber = new RoundNumber(roundNumber);
    }

    private Cars makeCars(String nameString) throws Exception {
        return new Cars(toNameList(nameString));
    }

    private List<Name> toNameList(String nameString) {
        List<Name> nameList = new ArrayList<>();
        List<String> nameStringList = Arrays.asList(nameString.split(","));
        for (String name : nameStringList) {
            nameList.add(new Name(name));
        }
        return nameList;
    }

    public LinkedHashMap<String, Integer> playOneRound(List<MovingAction> movingActions) {
        cars.move(movingActions);
        roundNumber.next();
        return cars.getCarsData();
    }

    public List<String> getResult() {
        return cars.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public RoundNumber getRoundNumber() {
        return roundNumber;
    }

    public boolean end() {
        return roundNumber.isMoreThanFinal();
    }

    public int getSizeOfCars() {
        return cars.getSize();
    }
}
