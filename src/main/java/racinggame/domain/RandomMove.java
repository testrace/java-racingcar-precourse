package racinggame.domain;

import nextstep.utils.Randoms;

public class RandomMove implements Movable {

    private static final int START = 0;
    private static final int END = 9;
    private static final int STANDARD = 4;

    @Override
    public boolean move() {
        return Randoms.pickNumberInRange(START, END) >= STANDARD;
    }

}
