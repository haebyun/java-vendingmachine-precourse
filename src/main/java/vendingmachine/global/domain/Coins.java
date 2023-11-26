package vendingmachine.global.domain;

import java.util.EnumMap;
import java.util.Map;
import vendingmachine.Coin;

public class Coins {
    private Map<Coin, Integer> coins;

    private Coins() {
        coins = new EnumMap<>(Coin.class);
    }
}
