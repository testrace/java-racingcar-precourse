package racinggame.domain;

public class Car {

    private final CarName name;
    private final Distance distance;

    public Car(CarName name) {
        this.name = name;
        this.distance = new Distance();
    }

    public Car(String name) {
        this(new CarName(name));
    }

    public String name() {
        return name.name();
    }

    public int distance() {
        return distance.value();
    }

}
