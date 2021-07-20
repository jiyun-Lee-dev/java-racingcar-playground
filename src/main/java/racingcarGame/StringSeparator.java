package racingcarGame;

import java.util.Arrays;
import java.util.List;

public class StringSeparator {
    private List<String> strings;
    private String delimiter;

    StringSeparator(String delimiter) {
        this.delimiter = delimiter;
    }

    public List<String> separate(String input) {
        return Arrays.asList(input.split(delimiter));
    }
}
