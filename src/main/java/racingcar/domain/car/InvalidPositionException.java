package racingcar.domain.car;

public class InvalidPositionException extends RuntimeException {

    private static final String NEGATIVE_MESSAGE = "위치 값은 0보다 작을 수 없습니다. 위치 값: %d";

    public InvalidPositionException(String message) {
        super(message);
    }

    public static InvalidPositionException ofNegative(int value) {
        return new InvalidPositionException(String.format(NEGATIVE_MESSAGE, value));
    }
}
