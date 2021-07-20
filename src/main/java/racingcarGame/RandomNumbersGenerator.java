package racingcarGame;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbersGenerator {
    private List<Integer> randomNumbers = new ArrayList<>();

    public List<Integer> generateNumbers(int size) {
        randomNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randomNumbers.add(generateNumber());
        }
        return randomNumbers;
    }

    private int generateNumber() {
        return (int)(Math.random() * 10);
    }

}
