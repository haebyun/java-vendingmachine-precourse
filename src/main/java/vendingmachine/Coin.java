package vendingmachine;

import java.util.Arrays;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin valueOf(int coinAmount) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.getAmount() == coinAmount)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException());
    }

    public static List<Integer> toAmounts() {
        return Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .toList();
    }

    public int getAmount() {
        return this.amount;
    }
}
