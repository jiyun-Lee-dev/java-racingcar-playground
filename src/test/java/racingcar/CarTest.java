package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 이름이_5글자를_초과하면_예외가_발생하는지_확인() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(new Name("cotton"), new Position(0));
        });
        String expectedMessage = "자동차 이름은 5글자를 초과할 수 없습니다.";
        String actualMessage = exception.getMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    void 
}
