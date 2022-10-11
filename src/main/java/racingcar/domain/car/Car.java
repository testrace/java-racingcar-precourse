package racingcar.domain.car;

import java.util.Objects;
import racingcar.domain.MovingStrategy;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this(name, Position.MINIMUM);
    }

    public Car(String name, int position) {
        this(new Name(name), Position.from(position));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return new Car(this.name, this.position.increase());
        }

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
