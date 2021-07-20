package racingcarGame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    public Car car;

    @BeforeEach
    void SetUp() {
        car = new Car("vanessee");
    }

    @Test
    public void 랜덤숫자가_5이상이면_0이었던_위치값을_1로_만들기() {
        car.move(4);
        assertThat(car.getLocation()).isEqualTo(0);
    }

}
