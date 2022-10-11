package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("자동차의 위치는 0부터 시작한다")
    @Test
    void defaultPositionIsZero() {
        Position actual = new Position();

        assertThat(actual).isEqualTo(new Position(0));
    }

}
