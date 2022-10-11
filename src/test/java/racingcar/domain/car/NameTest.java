package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class NameTest {

    @ParameterizedTest(name = "빈 값으로 이름을 생성할 수 없다. [{arguments}]")
    @NullAndEmptySource
    void nullAndEmpty(String value) {
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(InvalidNameException.class)
                .hasMessage("이름은 비어있을 수 없습니다.");
    }

}
