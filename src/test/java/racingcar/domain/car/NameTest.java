package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("5자를 초과하는 이름은 생성할 수 없다")
    @Test
    void invalidLengthOfName() {
        String overValue = "korando";

        String expectedMessage = String.format("이름은 5자를 초과할 수 없습니다. 이름: %s, 길이: %d",
                overValue, overValue.length());

        assertThatThrownBy(() -> new Name(overValue))
                .isInstanceOf(InvalidNameException.class)
                .hasMessage(expectedMessage);
    }

    @DisplayName("자동차 이름 생성")
    @Test
    void createName() {
        String value = "bmw";

        Name actual = new Name(value);

        assertThat(actual).isEqualTo(new Name("bmw"));
    }
}
