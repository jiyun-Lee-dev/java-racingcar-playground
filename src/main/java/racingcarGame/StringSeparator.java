package racingcarGame;

import java.util.Arrays;
import java.util.List;

public class StringSeparator {
    private List<String> strings;

    StringSeparator(String delimiter, String input) {
        this.strings = separate(delimiter, input);
    }

    private List<String> separate(String delimiter, String input) {
        return Arrays.asList(input.split(delimiter));
    }
}
