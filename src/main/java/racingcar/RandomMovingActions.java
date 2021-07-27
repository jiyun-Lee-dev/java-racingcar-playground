package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RandomMovingActions {
    private final List<MovingAction> movingActions;

    public RandomMovingActions(int sizeOfCars) {
        List<MovingAction> movingActions = new ArrayList<>();
        for (int i = 0; i < sizeOfCars; i++) {
            movingActions.add(new RandomMovingAction());
        }
        this.movingActions = movingActions;
    }

    public List<MovingAction> getMovingActions() {
        return movingActions;
    }
}
