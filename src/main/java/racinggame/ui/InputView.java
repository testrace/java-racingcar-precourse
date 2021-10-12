package racinggame.ui;

import nextstep.utils.Console;

public class InputView {

    private static final String CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String ERROR = "[ERROR] 잘못 입력하셨습니다. 다시 입력해주세요.";

    private InputView() {
        throw new IllegalStateException();
    }

    public static String carNames() {
        System.out.println(CAR_NAMES);
        return Console.readLine();
    }

    public static int tryCount() {
        System.out.println(TRY_COUNT);
        String tryCount = Console.readLine();
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR);
            return tryCount();
        }
    }
}
