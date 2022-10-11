package racingcar.domain.car;

import java.util.Objects;

public class Position {

    private static final int MINIMUM = 0;
    private static final int UNIT_OF_INCREASE = 1;

    private final int value;

    public Position() {
        this.value = MINIMUM;
    }

    public Position(int value) {
        if (value < MINIMUM) {
            throw InvalidPositionException.ofNegative(value);
        }
        this.value = value;
    }

    public Position increase() {
        return new Position(this.value + UNIT_OF_INCREASE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
