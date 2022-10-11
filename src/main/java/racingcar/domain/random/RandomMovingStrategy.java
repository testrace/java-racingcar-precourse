package racingcar.domain.random;

import racingcar.domain.MovingStrategy;

public class RandomMovingStrategy implements MovingStrategy {

    private final RandomRange randomRange;
    private final PositiveNumber movingInclusive;

    public RandomMovingStrategy(RandomRange randomRange, PositiveNumber movingInclusive) {
        this.randomRange = randomRange;
        this.movingInclusive = movingInclusive;
    }

    @Override
    public boolean movable() {
        return movingInclusive.greaterThanOrEquals(randomRange.pickNumber());
    }
}
