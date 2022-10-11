package racingcar.domain.random;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomMovingStrategyTest {

    @DisplayName("주어진 범위내에서 랜덤 값이 기준 값보다 크거나 같은지 판단한다")
    @ParameterizedTest(name = "범위 시작 값: {0}, 범위 종료 값: {1}, 기준 값: {2}, 기준 이상 여부: {3}")
    @CsvSource({
            "0, 9, 9, true",
            "1, 9, 0, false",
    })
    void eee(int start, int end, int standard, boolean expected) {
        RandomRange randomRange = new RandomRange(start, end);
        PositiveNumber movingInclusive = new PositiveNumber(standard);
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy(randomRange, movingInclusive);

        boolean actual = randomMovingStrategy.movable();

        assertThat(actual).isEqualTo(expected);
    }
}
