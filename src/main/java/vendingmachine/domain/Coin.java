package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public int getAmount() {
        return amount;
    }

    public static Coin findCoinByAmount(int amount) {
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() == amount) {
                return coin;
            }
        }
        return null; // 해당 금액의 동전이 없는 경우
    }

    public static Map<Coin, Integer> getChangeInformation(Map<Coin, Integer> coins, int amount) {
        List<Coin> sortedCoins = Arrays.stream(Coin.values())
                .sorted((coin1, coin2) -> Integer.compare(coin2.getAmount(), coin1.getAmount()))
                .toList();
        Map<Coin, Integer> changes = new HashMap<>();
        for (Coin coin : sortedCoins) {
            if (canPutChanges(coins, coin, amount)) {
                int coinCount = countCoin(coins, coin, amount);
                changes.put(coin, coinCount);
                amount -= coin.getAmount()*coinCount;
            }
        }
        return changes;
    }

    private static boolean canPutChanges(Map<Coin, Integer> coins, Coin coin, int amount) {
        return amount / coin.getAmount() > 0 && coins.get(coin) > 0;
    }

    private static int countCoin(Map<Coin, Integer> coins, Coin coin, int amount) {
        int cmp = amount / coin.getAmount();
        if(coins.get(coin) > cmp) {
            return cmp;
        }
        return coins.get(coin);
    }
}
