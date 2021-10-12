package racinggame.domain;

public class CarName {

    private static final int MAX_LENGTH = 5;

    private final String value;

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.isEmpty()) {
            throw new CarNameException("자동차 이름은 반드시 존재해야 합니다.");
        }
        if (value.length() > MAX_LENGTH) {
            throw new CarNameException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String name() {
        return value;
    }
}
