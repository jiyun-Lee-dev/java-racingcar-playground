package racingcarGame;

public class Car {
    private String name;
    private int location;

    Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void move(int dist) {
        CarStatus carStatus = doOneLap(dist);
        if (CarStatus.isPass(carStatus)) {
            location += 1;
        }
    }

    private CarStatus doOneLap(int i) {
        if (i >= 5) {
            return CarStatus.PASS;
        }
        return CarStatus.FAIL;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
