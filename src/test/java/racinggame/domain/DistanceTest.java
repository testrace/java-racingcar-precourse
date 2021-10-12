package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DistanceTest {

    Distance distance;

    @BeforeEach
    void setUp() {
        distance = new Distance();
    }

    @Test
    @DisplayName("초기화")
    void init() {

        //when
        int actual = distance.value();

        //then
        assertThat(actual).isZero();

    }

    @Test
    @DisplayName("이동 거리 증가")
    void increase() {
        //when
        distance.increase();
        int actual = distance.value();

        //then
        assertThat(actual).isEqualTo(1);
    }
}