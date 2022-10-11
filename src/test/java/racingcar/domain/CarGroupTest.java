package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.domain.car.Car;
import racingcar.domain.car.Position;

class CarGroupTest {


    final Car bmw = createCar("bmw", 3);
    final Car benz = createCar("benz", 3);
    final Car audi = createCar("audi", 2);

    @DisplayName("이름으로 자동차들을 생성한다")
    @Test
    void createCarGroup() {
        List<String> names = Arrays.asList("bmw", "benz", "audi");

        CarGroup actual = CarGroup.from(names);
        CarGroup expected = CarGroup.from(Arrays.asList("bmw", "benz", "audi"));

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("자동차의 이름없이 자동차들을 생성하면 예외가 발생한다")
    @ParameterizedTest
    @NullAndEmptySource
    void createExceptionWhenHasNoNames(List<String> names) {
        assertThatThrownBy(() -> CarGroup.from(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차가 1대만 있는 경우 예외가 발생한다. 2대 이상의 자동차가 있어야 경주가 가능하다")
    @Test
    void createExceptionWhenHasOnlyOneName() {
        List<String> aloneName = Collections.singletonList("bmw");

        assertThatThrownBy(() -> CarGroup.from(aloneName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차들을 움직이게 한다.")
    @Test
    void movedAllCars() {
        List<String> names = Arrays.asList("bmw", "benz", "audi");

        CarGroup cars = CarGroup.from(names);

        CarGroup actual = cars.move(new MustBeTrue());

        assertThat(actual).isNotEqualTo(CarGroup.from(names));
    }

    @DisplayName("자동차들을 움직이지 않게 한다.")
    @Test
    void allTheCarsDidNotMove() {
        List<String> names = Arrays.asList("bmw", "benz", "audi");

        CarGroup cars = CarGroup.from(names);

        CarGroup actual = cars.move(new MustBeFalse());

        assertThat(actual).isEqualTo(CarGroup.from(names));
    }

    @DisplayName("가장 멀리간 자동차의 위치를 찾는다")
    @Test
    void findMaxPositionCar() {

        CarGroup cars = new CarGroup(createFixtureCarGroup());

        Position actual = cars.getMaxPosition();

        assertThat(actual).isEqualTo(Position.from(3));
    }

    @DisplayName("특정 위치와 동일한 자동차들을 찾는다")
    @Test
    void findSamePositionCarGroup() {
        CarGroup cars = new CarGroup(createFixtureCarGroup());

        CarGroup actual = cars.findSamePositionCars(Position.from(3));

        assertThat(actual).isEqualTo(new CarGroup(Arrays.asList(bmw, benz)));
    }

    private static class MustBeTrue implements MovingStrategy {

        @Override
        public boolean movable() {
            return true;
        }
    }

    private static class MustBeFalse implements MovingStrategy {

        @Override
        public boolean movable() {
            return false;
        }
    }

    private List<Car> createFixtureCarGroup() {
        return Arrays.asList(bmw, benz, audi);
    }

    private Car createCar(final String name, final int position) {
        return new Car(name, position);
    }

}
