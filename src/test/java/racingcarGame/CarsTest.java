package racingcarGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    public Cars cars;

    @BeforeEach
    void SetUp() throws Exception {
        cars = new Cars(Arrays.asList("a", "b", "c"));
    }

    @Test
    void car_5개_이상으로_들어오면_적절한_예외발생시키기() {
        Exception exception = assertThrows(Exception.class, () -> {
            Cars testCars = new Cars(Arrays.asList("a", "b", "c", "d", "e", "f"));
        });
        String expectedMessage = "자동차는 2개 이상, 5개 이하로 생성할 수 있습니다.";
        String actualMessage = exception.getMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    void 주어진_랜덤숫자들에_따라서_각_자동차의_이름과_위치를_제대로_가져오는지() throws Exception {
        cars.moveCars(Arrays.asList(3, 5, 7));
        cars.moveCars(Arrays.asList(6, 5, 2));
        cars.moveCars(Arrays.asList(1, 5, 6));
        // car 객체를 반환하기 보다 이름이랑 위치 정보만 리턴해주고 싶었음.
        LinkedHashMap<String, Integer> expected = new LinkedHashMap<String, Integer>();
        expected.put("a", 1);
        expected.put("b", 3);
        expected.put("c", 2);
        assertThat(cars.getAllCarsData()).isEqualTo(expected);
    }

    @Test
    void 주어진_랜덤숫자들에_따라서_가장_멀리_간_자동차를_제대로_가져오는지_확인하기() throws Exception {
        cars.moveCars(Arrays.asList(3, 5, 7));
        cars.moveCars(Arrays.asList(6, 5, 2));
        cars.moveCars(Arrays.asList(1, 5, 6));
        assertThat(cars.getWinners()).isEqualTo(Arrays.asList("b"));
    }

}