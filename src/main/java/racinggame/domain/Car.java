package racinggame.domain;

import nextstep.utils.Randoms;

public class Car {

    private final CarName name;

    public Car(CarName name) {
        this.name = name;
    }

    public Car(String name) {
        this(new CarName(name));
    }

    public String name() {
        return name.name();
    }

}
