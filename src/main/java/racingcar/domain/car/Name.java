package racingcar.domain.car;

public class Name {

    public Name(String value) {
        if (value == null || value.isEmpty()) {
            throw InvalidNameException.ofNull();
        }
    }
}
