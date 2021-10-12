package racinggame.ui;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Distance;

public class ResultView {

    private static final String RESULT_FORMAT = "%s : %s%n";
    private static final String DASH = "-";
    private static final String WINNERS_MESSAGE = "최종 우승자는 %s 입니다.%n";

    public static void printRace(Cars cars) {
        for (Car car : cars.cars()) {
            System.out.printf(RESULT_FORMAT, car.name(), dash(car.distance()));
        }
        System.out.println();
    }

    private static String dash(Distance distance) {
        StringBuilder dash = new StringBuilder();
        for (int i = 0; i < distance.value(); i++) {
            dash.append(DASH);
        }
        return dash.toString();
    }

    public static void printWinner(Cars winners) {
        System.out.printf(WINNERS_MESSAGE, String.join(",", winners.names()));
    }
}
