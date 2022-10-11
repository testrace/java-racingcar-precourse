package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @DisplayName("자동차의 위치는 0부터 시작한다")
    @Test
    void defaultPositionIsZero() {
        final Position actual = new Position();

        assertThat(actual).isEqualTo(new Position(0));
    }

    @DisplayName("자동차의 위치는 0보다 작을 수 없다.")
    @Test
    void positionIsPositive() {
        Assertions.assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(InvalidPositionException.class)
                .hasMessage("위치 값은 0보다 작을 수 없습니다. 위치 값: -1");

    }

    @DisplayName("자동차의 위치는 1씩 증가한다")
    @Test
    void increase() {
        final Position position = new Position();

        final Position actual = position.increase();

        assertThat(actual).isEqualTo(new Position(1));
    }

}
