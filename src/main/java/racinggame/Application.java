package racinggame;

import racinggame.controller.RacingCar;
import racinggame.domain.CarNameException;
import racinggame.domain.CarsException;
import racinggame.ui.InputView;
import racinggame.ui.ResultView;

public class Application {

    private static final String RESULT_MESSAGE = "%n실행 결과%n";
    private static final String ERROR = "[ERROR] 잘못 입력하셨습니다. 다시 입력해주세요. ";

    public static void main(String[] args) {

        RacingCar racingCar = inputNames();
        int tryCount = InputView.tryCount();

        System.out.printf(RESULT_MESSAGE);
        for (int i = 0; i < tryCount; i++) {
            racingCar.move();
            ResultView.printRace(racingCar.cars());
        }

        ResultView.printWinner(racingCar.winners());
    }

    private static RacingCar inputNames() {
        try {
            return new RacingCar(InputView.carNames());
        } catch (CarNameException | CarsException ex) {
            System.out.println(ERROR + ex.getMessage());
            return inputNames();
        }
    }


}
