package vendingmachine.global.domain;

import java.util.EnumMap;
import java.util.Map;
import vendingmachine.Coin;

public class Coins {
    private Map<Coin, CoinCount> coins;

    private Coins() {
        coins = new EnumMap<>(Coin.class);
    }
}
