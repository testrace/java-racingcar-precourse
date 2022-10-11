package racingcar.domain.car;

public class InvalidNameException extends RuntimeException {

    private static final String NULL_OR_EMPTY = "이름은 비어있을 수 없습니다.";

    private InvalidNameException(String message) {
        super(message);
    }

    public static InvalidNameException ofNull() {
        return new InvalidNameException(NULL_OR_EMPTY);
    }

}
