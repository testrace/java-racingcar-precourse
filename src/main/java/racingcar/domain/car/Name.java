package racingcar.domain.car;

public class Name {

    public Name(String value) {
        validate(value);
    }

    private static void validate(String value) {
        validateNullOrEmpty(value);
        validateLimitLength(value);
    }

    private static void validateLimitLength(String value) {
        if (value.length() > InvalidNameException.LIMIT_LENGTH) {
            throw InvalidNameException.ofLimitLength(value.length());
        }
    }

    private static void validateNullOrEmpty(String value) {
        if (value == null || value.isEmpty()) {
            throw InvalidNameException.ofNull();
        }
    }
}
