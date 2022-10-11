package racingcar.domain;

import java.util.Objects;
import racingcar.domain.car.Position;

public class Winners {

    private final CarGroup cars;

    public Winners(final CarGroup cars) {
        this.cars = cars;
    }

    public static Winners find(CarGroup carGroup) {
        final Position maxPosition = carGroup.getMaxPosition();

        final CarGroup samePositionCars = carGroup.findSamePositionCars(maxPosition);

        return new Winners(samePositionCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winners winners = (Winners) o;
        return Objects.equals(cars, winners.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
