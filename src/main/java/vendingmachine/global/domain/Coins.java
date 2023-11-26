package vendingmachine.global.domain;

import java.util.EnumMap;
import java.util.Map;
import vendingmachine.Coin;

public class Coins {
    private Map<Coin, Integer> coins;

    public Coins() {
        coins = new EnumMap<>(Coin.class);
    }

    public void add(Coin coin) {
        coins.put(coin, coins.getOrDefault(coin, 0) + 1);
    }
}
