package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private static Distance max;

    private Winners() {
        throw new IllegalStateException();
    }

    public static Cars select(Cars cars) {
        max(cars);
        return winners(cars);
    }

    private static Cars winners(Cars cars) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars.cars()) {
            addWinner(winners, car);
        }
        return new Cars(winners);
    }

    private static void addWinner(List<Car> winners, Car car) {
        if (max.equals(car.distance())) {
            winners.add(car);
        }
    }

    private static void max(Cars cars) {
        max = new Distance();
        for (Car car : cars.cars()) {
            max = Distance.max(max, car.distance());
        }
    }

}
