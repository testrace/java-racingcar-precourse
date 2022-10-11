package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
