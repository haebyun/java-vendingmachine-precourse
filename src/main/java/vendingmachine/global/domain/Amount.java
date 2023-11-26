package vendingmachine.global.domain;

public class Amount {
    private final int amount;

    private Amount(int amount) {
        this.amount = amount;
    }

    public static Amount from(int amount) {
        return new Amount(amount);
    }

    public int getValue() {
        return amount;
    }
}
