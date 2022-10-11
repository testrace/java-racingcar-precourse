package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racingcar.domain.car.Car;

public class CarGroup {

    private final List<Car> cars;

    private CarGroup(List<Car> cars) {
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
        if (cars == null || insufficientCars(cars)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean insufficientCars(List<?> cars) {
        return cars.isEmpty() || cars.size() == 1;
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
