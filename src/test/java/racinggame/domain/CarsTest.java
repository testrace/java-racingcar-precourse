package racinggame.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(
                Arrays.asList(
                        new Car("java"),
                        new Car("cpp"),
                        new Car("go")
                )
        );
    }

    @Test
    @DisplayName("자동차 대수")
    void size() {
        //when
        List<Car> actual = this.cars.cars();

        //then
        assertThat(actual).hasSize(3);

    }

    @Test
    @DisplayName("자동차 대수 예외")
    void construct_exception() {
        //when
        ThrowableAssert.ThrowingCallable actual = () -> new Cars("cars");

        //then
        assertThatThrownBy(actual).isInstanceOf(CarsException.class)
                .hasMessage("자동차 경주는 2대 이상만 가능합니다.");

    }

}