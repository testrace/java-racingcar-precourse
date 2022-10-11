package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {


    @DisplayName("자동차는 이름과 위치를 가진다")
    @Test
    void constructor() {
        final String carName = "f10";
        final Car actual = new Car(carName);

        final Car expected = new Car(carName, 0);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("자동차가 전진하면 위치 값이 변경된다")
    @Test
    void move() {
        final String carName = "528i";
        final Car car = new Car(carName);

        final Car actual = car.move(() -> true);

        assertThat(actual).isEqualTo(new Car(carName, 1));
    }

    @DisplayName("자동차는 움직이지 않으면 위치 값의 변경이 없다")
    @Test
    void didntMove() {
        final String carName = "528i";
        final Car car = new Car(carName);

        final Car actual = car.move(() -> false);

        assertThat(actual).isEqualTo(new Car(carName));
    }

    @DisplayName("위치 값을 비교하여 큰 위치 값을 반환한다")
    @Test
    void greaterThanPosition() {
        Car bmw = new Car("bmw", 3);
        Position comparePosition = Position.from(2);

        Position actual = bmw.greaterThanPosition(comparePosition);

        assertThat(actual).isEqualTo(Position.from(3));
    }

    @DisplayName("자동차의 위치가 특정 위치와 동일한지 확인한다")
    @ParameterizedTest
    @CsvSource({
            "2, false",
            "3, true"
    })
    void hasSamePosition(int value, boolean expected) {
        Car bmw = new Car("bmw", 3);
        Position comparePosition = Position.from(value);

        boolean actual = bmw.hasSamePosition(comparePosition);

        assertThat(actual).isEqualTo(expected);
    }

}
