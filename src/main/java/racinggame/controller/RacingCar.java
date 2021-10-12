package racinggame.controller;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.RandomMove;

public class RacingCar {

    private Cars cars;

    public RacingCar(String carNames) {
        this.cars = new Cars(carNames);
    }

    public void move() {
        for (Car car : cars.cars()) {
            car.move(new RandomMove());
        }
    }

    public Cars cars() {
        return cars;
    }
}
