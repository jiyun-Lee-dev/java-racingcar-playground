package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private MovingAction successMoving;
    private MovingAction failMoving;

    @BeforeEach
    void setUp() {
        successMoving = () -> true;
        failMoving = () -> false;
    }

    @Test
    void 시도회수_5초과면_예외발생시키는거_확인() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RacingGame racingGame = new RacingGame("a,b,c", 6);
        });
        String expectedMessage = "시도회수는 최대 5까지만 가능합니다.";
        String actualMessage = exception.getMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Test
    void 주어진_값에_따라_우승자목록을_뽑아내는지_확인() throws Exception {
        RacingGame racingGame = new RacingGame("a,b,c", 3);
        racingGame.playOneRound(Arrays.asList(successMoving, successMoving, failMoving));
        racingGame.playOneRound(Arrays.asList(failMoving, successMoving, failMoving));
        racingGame.playOneRound(Arrays.asList(failMoving, successMoving, successMoving));
        assertThat(racingGame.getResult()).contains("b");
    }

}
