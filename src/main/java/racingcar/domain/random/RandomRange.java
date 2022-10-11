package racingcar.domain.random;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomRange {

    private final PositiveNumber startInclusive;
    private final PositiveNumber endInclusive;

    public RandomRange(PositiveNumber startInclusive, PositiveNumber endInclusive) {
        validateRange(startInclusive, endInclusive);
        this.startInclusive = startInclusive;
        this.endInclusive = endInclusive;
    }

    private void validateRange(PositiveNumber startInclusive, PositiveNumber endInclusive) {
        if (startInclusive.greaterThanOrEquals(endInclusive)) {
            throw new IllegalArgumentException("범위 설정 잘못됨");
        }
    }

    public RandomRange(int startInclusive, int endInclusive) {
        this(new PositiveNumber(startInclusive), new PositiveNumber(endInclusive));
    }

    public PositiveNumber pickNumber() {
        return new PositiveNumber(Randoms.pickNumberInRange(startInclusive.getValue(), endInclusive.getValue()));
    }
}
