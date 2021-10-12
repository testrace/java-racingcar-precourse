package racinggame.domain;

public class Distance {

    private static final int DEFAULT_VALUE = 0;

    private int value;

    public Distance(int value) {
        this.value = value;
    }

    public Distance() {
        this(DEFAULT_VALUE);
    }

    public int value() {
        return value;
    }

    public void increase() {
        value++;
    }

}
