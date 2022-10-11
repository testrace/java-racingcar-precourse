package racingcar;

import java.util.Arrays;
import racingcar.domain.CarGroup;
import racingcar.domain.Winners;
import racingcar.domain.random.PositiveNumber;
import racingcar.domain.random.RandomMovingStrategy;
import racingcar.domain.random.RandomRange;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class Application {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVE_STANDARD = 4;

    public static void main(String[] args) {

        String names = InputView.inputNames();
        CarGroup carGroup = CarGroup.from(Arrays.asList(names.split(",")));

        RandomRange randomRange = new RandomRange(START_INCLUSIVE, END_INCLUSIVE);
        PositiveNumber movingInclusive = new PositiveNumber(MOVE_STANDARD);
        RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy(randomRange, movingInclusive);

        int tryCount = InputView.tryCount();
        ResultView.printResult();

        for (int i = 0; i < tryCount; i++) {
            carGroup = carGroup.move(randomMovingStrategy);
            ResultView.printRace(carGroup);
        }

        ResultView.printWinner(Winners.find(carGroup));
    }


}
