package racingcar.domain.car;

import java.util.Objects;

public class Name {

    private final String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        validateNullOrEmpty(value);
        validateLimitLength(value);
    }

    private void validateLimitLength(String value) {
        if (value.length() > InvalidNameException.LIMIT_LENGTH) {
            throw InvalidNameException.ofLimitLength(value);
        }
    }

    private void validateNullOrEmpty(String value) {
        if (value == null || value.isEmpty()) {
            throw InvalidNameException.ofNull();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
