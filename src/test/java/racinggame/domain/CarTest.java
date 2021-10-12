package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car");
    }

    @ParameterizedTest(name = "자동차 이동 {index} [{arguments}]")
    @CsvSource(value = {
            "true,1",
            "false,0",
    })
    @DisplayName("자동차 이동")
    void move(boolean movable, int expected) {
        //given

        //when
        car.move(() -> movable);
        int actual = car.distance();

        //then
        assertThat(actual).isEqualTo(expected);

    }

}