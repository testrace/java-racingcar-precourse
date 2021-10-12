package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car");
    }

}