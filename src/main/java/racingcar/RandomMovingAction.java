package racingcar;

public class RandomMovingAction implements MovingAction {
    private static final int FORWARD_BOUND = 5;

    @Override
    public boolean movable() {
        return getRandomNumber() >= FORWARD_BOUND;
    }

    private int getRandomNumber() {
        return (int)(Math.random() * 10);
    }
}
