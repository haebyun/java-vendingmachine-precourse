package vendingmachine.global.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import vendingmachine.Coin;

public class VendingMachine {
    private Coins coins;
    private Amount amount;

    private VendingMachine(Amount amount) {
        coins = new Coins();
        generateCoins(amount.getValue());
        this.amount = amount;
    }

    public static VendingMachine of(Amount amount) {
        return new VendingMachine(amount);
    }

    private void generateCoins(int amount) {
        while (amount > 0) {
            Coin coin = getRandomCoin();
            coins.add(coin);
            amount -= coin.getAmount();
        }
    }

    private Coin getRandomCoin() {
        List<Integer> coinAmounts = Coin.toAmounts();
        int coinAmount = Randoms.pickNumberInList(coinAmounts);
        return Coin.valueOf(coinAmount);
    }
}
