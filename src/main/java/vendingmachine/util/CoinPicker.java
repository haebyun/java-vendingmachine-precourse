package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import vendingmachine.domain.Coin;

public class CoinPicker {
    private final List<Integer> amountCoins = new ArrayList<>();

    public CoinPicker() {
        Arrays.stream(Coin.values())
                .forEach(coin -> amountCoins.add(coin.getAmount()));
    }

    public int pick(int amount) {
        while (true) {
            int pickedAmount = Randoms.pickNumberInList(amountCoins);
            if (pickedAmount <= amount) {
                return pickedAmount;
            }
        }
    }
}
