package vendingmachine.global.domain;

public class VendingMachine {
    private Coins coins;
    private Amount amount;

    private VendingMachine(Coins coins, Amount amount) {
        this.coins = coins;
        this.amount = amount;
    }

    public static void of(Amount amount) {
        Coins coins = generateCoins(amount.getValue());
    }

    private static Coins generateCoins(int amount) {

    }
}
