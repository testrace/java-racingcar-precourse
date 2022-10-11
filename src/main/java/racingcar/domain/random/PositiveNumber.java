package racingcar.domain.random;

import java.util.Objects;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public boolean greaterThanOrEquals(PositiveNumber otherPositiveNumber) {
        return this.value >= otherPositiveNumber.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PositiveNumber positiveNumber = (PositiveNumber) o;
        return value == positiveNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
