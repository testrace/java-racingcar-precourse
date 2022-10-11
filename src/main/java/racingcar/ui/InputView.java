package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_NAMES = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";

    private static final String TRY_COUNT = "시도할 회수";

    private InputView() {
    }

    public static String inputNames() {
        System.out.println(INPUT_NAMES);
        return input();
    }

    public static int tryCount() {
        System.out.println(TRY_COUNT);
        return Integer.parseInt(input());
    }

    private static String input() {
        try {
            return Console.readLine();
        } catch (Exception ex) {
            ResultView.printErrorMessage();
            return input();
        }
    }

}
