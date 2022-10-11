package racingcar.domain.car;

public class InvalidNameException extends RuntimeException {

    public static final int LIMIT_LENGTH = 5;

    private static final String NULL_OR_EMPTY_MESSAGE = "이름은 비어있을 수 없습니다.";
    private static final String LIMIT_LENGTH_MESSAGE = "이름은 5자를 초과할 수 없습니다. 이름: %s, 길이: %d";

    private InvalidNameException(String message) {
        super(message);
    }

    public static InvalidNameException ofNull() {
        return new InvalidNameException(NULL_OR_EMPTY_MESSAGE);
    }

    public static InvalidNameException ofLimitLength(String value) {
        return new InvalidNameException(String.format(LIMIT_LENGTH_MESSAGE, value, value.length()));
    }

}
