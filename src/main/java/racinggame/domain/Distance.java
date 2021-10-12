package racinggame.domain;

import java.util.Objects;

public class Distance {

    private static final int DEFAULT_VALUE = 0;

    private int value;

    public Distance(int value) {
        this.value = value;
    }

    public Distance() {
        this(DEFAULT_VALUE);
    }

    public int value() {
        return value;
    }

    public void increase() {
        value++;
    }

    public static Distance max(Distance before, Distance after) {
        if (before.value() > after.value()) {
            return before;
        }
        return after;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
