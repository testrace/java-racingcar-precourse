package racinggame.domain;

import java.util.Objects;

public class Car {

    private final CarName name;
    private final Distance distance;

    public Car(CarName name, Distance distance) {
        this.name = name;
        this.distance = distance;
    }

    public Car(String name) {
        this(new CarName(name), new Distance());
    }

    public Car(String name, int distance) {
        this(new CarName(name), new Distance(distance));
    }

    public String name() {
        return name.name();
    }

    public Distance distance() {
        return distance;
    }

    public void move(Movable movable) {
        if (movable.move()) {
            distance.increase();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
