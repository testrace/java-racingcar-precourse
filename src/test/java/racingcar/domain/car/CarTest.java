package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {


    @DisplayName("자동차는 이름과 위치를 가진다")
    @Test
    void constructor() {
        String carName = "f10";
        Car actual = new Car(carName);

        Car expected = new Car(carName, 0);

        assertThat(actual).isEqualTo(expected);
    }

}
