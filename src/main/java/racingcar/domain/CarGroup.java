package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import racingcar.domain.car.Car;
import racingcar.domain.car.Position;

public class CarGroup {

    private final List<Car> cars;

    public CarGroup(List<Car> cars) {
        validateSize(cars);
        this.cars = cars;
    }

    public static CarGroup from(List<String> carNames) {
        validateSize(carNames);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new CarGroup(cars);
    }

    private static void validateSize(List<?> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public CarGroup move(MovingStrategy movingStrategy) {
        List<Car> movedCars = new ArrayList<>();
        for (Car car : this.cars) {
            movedCars.add(car.move(movingStrategy));
        }
        return new CarGroup(movedCars);
    }

    public Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = car.greaterThanPosition(maxPosition);
        }
        return maxPosition;
    }

    public CarGroup findSamePositionCars(Position position) {
        List<Car> maxPositionCars = new ArrayList<>();
        for (Car car : cars) {
            extractSamePositionCars(position, maxPositionCars, car);
        }
        return new CarGroup(maxPositionCars);
    }

    private void extractSamePositionCars(Position position, List<Car> maxPositionCars, Car car) {
        if (car.hasSamePosition(position)) {
            maxPositionCars.add(car);
        }
    }

    public List<String> names() {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            names.add(car.getName());
        }
        return names;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarGroup carGroup = (CarGroup) o;
        return Objects.equals(cars, carGroup.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
