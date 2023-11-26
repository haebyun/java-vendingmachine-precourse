package vendingmachine.global.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import vendingmachine.Coin;
import vendingmachine.global.controller.dto.response.CoinResponse;
import vendingmachine.global.controller.dto.response.CoinsResponse;

public class Coins {
    private Map<Coin, Integer> coins;

    public Coins() {
        coins = new EnumMap<>(Coin.class);
    }

    public void add(Coin coin) {
        coins.put(coin, coins.getOrDefault(coin, 0) + 1);
    }

    public CoinsResponse toCoinsResponse() {
        List<CoinResponse> coinResponses = coins.entrySet()
                .stream()
                .map(entry -> new CoinResponse(
                        entry.getKey().getAmount(), entry.getValue())
                )
                .toList();
        return new CoinsResponse(coinResponses);
    }
}
