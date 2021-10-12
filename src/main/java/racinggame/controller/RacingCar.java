package racinggame.controller;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.RandomMove;
import racinggame.domain.Winners;

public class RacingCar {

    private static final RandomMove randomMove = new RandomMove();

    private Cars cars;

    public RacingCar(String carNames) {
        this.cars = new Cars(carNames);
    }

    public void move() {
        for (Car car : cars.cars()) {
            car.move(randomMove);
        }
    }

    public Cars cars() {
        return cars;
    }

    public Cars winners() {
        return Winners.select(cars);
    }

}
