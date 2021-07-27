package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CarsTest {
    private Cars cars;
    private MovingAction successMoving;
    private MovingAction failMoving;

    @BeforeEach
    void setUp() throws Exception {
        cars = new Cars(Arrays.asList(new Name("a"), new Name("b"), new Name("c")));
        successMoving = () -> true;
        failMoving = () -> false;
    }

    @Test
    void 자동차가_1개_이상_만들어지지_않으면_예외발생() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cars = new Cars(Arrays.asList(new Name("a")));
        });
        String expectedMessage = "자동차는 최소 1개 이상이어야 합니다.";
        String actualMessage = exception.getMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    void 우승자를_제대로_뽑는지_확인() {
        cars.move(Arrays.asList(successMoving, successMoving, failMoving));
        List<String> winners = cars.getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        assertThat(winners).contains("a", "b");
    }

    @Test
    void 자동차별_이름과_위치정보를_제대로_가져오는지_확인() {
        cars.move(Arrays.asList(successMoving, successMoving, failMoving));
        LinkedHashMap<String, Integer> data = cars.getCarsData();
        assertThat(data.get("a")).isEqualTo(1);
        assertThat(data.get("b")).isEqualTo(1);
        assertThat(data.get("c")).isEqualTo(0);
    }
}
