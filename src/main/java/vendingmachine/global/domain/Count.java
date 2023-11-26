package vendingmachine.global.domain;

public class Count {
    private int count;

    private Count(int count) {
        this.count = count;
    }

    public static Count valueOf(int count) {
        return new Count(count);
    }
}
