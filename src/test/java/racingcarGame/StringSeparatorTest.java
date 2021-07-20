package racingcarGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class StringSeparatorTest {
    public StringSeparator stringSeparator;

    @BeforeEach
    void SetUp() {
        stringSeparator = new StringSeparator(",");
    }

    @Test
    void 문자열_제대로_쪼개는지_확인() {
        assertThat(stringSeparator.separate("a, b, c")).isEqualTo(Arrays.asList("a", "b", "c"));
    }


}