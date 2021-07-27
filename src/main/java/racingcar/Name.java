package racingcar;

public class Name {
    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public int getLength() {
        return name.length();
    }

    public String getValue() {
        return name;
    }
}
