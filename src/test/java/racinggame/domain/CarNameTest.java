package racinggame.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarNameTest {

    @Test
    @DisplayName("5자 초과 이름")
    void length_over_exception() {
        //given
        String name = "longname";

        //when
        ThrowableAssert.ThrowingCallable actual = () -> new CarName(name);

        //then
        assertThatThrownBy(actual).isInstanceOf(CarNameException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("비어있는 이름")
    void zero_exception() {
        //given
        String name = "";

        //when
        ThrowableAssert.ThrowingCallable actual = () -> new CarName(name);

        //then
        assertThatThrownBy(actual).isInstanceOf(CarNameException.class)
                .hasMessage("자동차 이름은 반드시 존재해야 합니다.");
    }

}