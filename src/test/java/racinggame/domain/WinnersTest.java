package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinnersTest {

    @Test
    @DisplayName("우승자 구하기")
    void winners() {
        //given
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("java", 1),
                        new Car("cpp", 1),
                        new Car("go")
                )
        );

        //when
        List<String> select = Winners.select(cars)
                .names();

        //then
        assertThat(select).contains("java", "cpp");

    }

}