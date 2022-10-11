package racingcar.domain.random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositiveNumberTest {

    @DisplayName("0이상의 양수를 생성한다")
    @Test
    void create() {
        PositiveNumber actual = new PositiveNumber(0);

        assertThat(actual).isEqualTo(new PositiveNumber(0));
    }
    
    
    @DisplayName("0이하의 숫자로 생성 시 예외가 발생한다")
    @Test
    void createException() {
        assertThatThrownBy(() -> new PositiveNumber(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("포장한 숫자의 크기를 비교할 수 있다")
    @ParameterizedTest
    @CsvSource(value = {
            "4, true",
            "5, false"
    })
    void greaterThanOrEquals(int number, boolean expected) {
        PositiveNumber positiveNumber = new PositiveNumber(4);

        boolean actual = positiveNumber.greaterThanOrEquals(new PositiveNumber(number));

        assertThat(actual).isEqualTo(expected);

    }
}
