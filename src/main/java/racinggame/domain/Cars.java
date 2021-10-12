package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MIN_CARS_COUNT = 2;

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public Cars(String cars) {
        String[] carNames = cars.split(CAR_NAME_DELIMITER);
        validateLength(carNames.length);
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    private void validateLength(int lengthOfNames) {
        if (lengthOfNames < MIN_CARS_COUNT) {
            throw new CarsException("자동차 경주는 2대 이상만 가능합니다.");
        }
    }

    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> names() {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            names.add(car.name());
        }
        return names;
    }

}
