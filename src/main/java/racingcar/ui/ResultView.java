package racingcar.ui;

import racingcar.domain.CarGroup;
import racingcar.domain.Winners;
import racingcar.domain.car.Car;

public class ResultView {

    private ResultView() {
    }

    private static final String RESULT_MESSAGE = "%n실행 결과%n";
    private static final String RESULT_FORMAT = "%s : %s%n";
    private static final String DASH = "-";
    private static final String WINNERS_MESSAGE = "최종 우승자 : %s";
    private static final String ERROR_MESSAGE = "[ERROR] 잘못 입력하셨습니다. 다시 입력해주세요. ";


    public static void printResult() {
        System.out.printf(RESULT_MESSAGE);
    }

    public static void printRace(CarGroup carGroup) {
        for (Car car : carGroup.getCars()) {
            System.out.printf(RESULT_FORMAT, car.getName(), dash(car.getPosition()));
        }
        System.out.println();
    }

    private static String dash(int position) {
        StringBuilder dash = new StringBuilder();
        for (int i = 0; i < position; i++) {
            dash.append(DASH);
        }
        return dash.toString();
    }

    public static void printWinner(Winners winners) {
        System.out.printf(WINNERS_MESSAGE, String.join(", ", winners.names()));
    }

    public static void printErrorMessage() {
        System.out.println(ERROR_MESSAGE);
    }

}
