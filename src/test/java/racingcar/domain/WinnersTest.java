package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

class WinnersTest {

    final Car bmw = createCar("bmw", 3);
    final Car benz = createCar("benz", 3);
    final Car audi = createCar("audi", 2);

    @DisplayName("우승자를 찾는다")
    @Test
    void find() {
        CarGroup carGroup = new CarGroup(createFixtureCarGroup());

        Winners actual = Winners.find(carGroup);
        Winners expected = new Winners(new CarGroup(Arrays.asList(bmw, benz)));

        assertThat(actual).isEqualTo(expected);
    }

    private List<Car> createFixtureCarGroup() {
        return Arrays.asList(bmw, benz, audi);
    }

    private Car createCar(final String name, final int position) {
        return new Car(name, position);
    }

}
