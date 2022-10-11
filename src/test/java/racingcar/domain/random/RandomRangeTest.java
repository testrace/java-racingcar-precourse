package racingcar.domain.random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomRangeTest {

    @DisplayName("랜덤 값의 범위를 설정한다")
    @Test
    void create() {
        RandomRange randomRange = new RandomRange(0, 9);

        PositiveNumber pick = randomRange.pickNumber();

        assertThat(pick.getValue()).isBetween(0, 9);
    }

    @DisplayName("범위 종료 값이 범위 시작값보다 작거나 같으면 예외가 발생한다")
    @ParameterizedTest(name = "시작 값: 2, 종료 값: {0}")
    @ValueSource(ints = {1, 2})
    void startNumberIsGraterThanEndNumber(int endInclusive) {
        assertThatThrownBy(() -> new RandomRange(2, endInclusive))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
