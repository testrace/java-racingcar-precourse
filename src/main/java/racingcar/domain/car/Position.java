package racingcar.domain.car;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {

    private static final int MINIMUM = 0;
    private static final int UNIT_OF_INCREASE = 1;
    private static final Map<Integer, Position> CACHE = new HashMap<>();

    private final int value;

    public Position() {
        this(MINIMUM);
    }

    public Position(int value) {
        if (value < MINIMUM) {
            throw new InvalidPositionException(value);
        }
        this.value = value;
        CACHE.putIfAbsent(value, this);
    }

    public static Position from(int value) {
        return CACHE.computeIfAbsent(value, Position::new);
    }

    public Position increase() {
        return from(value + UNIT_OF_INCREASE);
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
