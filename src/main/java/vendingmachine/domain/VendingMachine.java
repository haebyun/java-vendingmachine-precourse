package vendingmachine.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import vendingmachine.util.CoinPicker;

public class VendingMachine {
    private Map<Coin, Integer> coins;
    private Map<Item, Integer> items;
    private final CoinPicker coinPicker = new CoinPicker();

    public VendingMachine(int availableAmount) {
        initCoins(availableAmount);
    }

    private void initCoins(int amount) {
        Arrays.stream(Coin.values())
                .forEach(coin -> coins.put(coin, 0));
        while (amount > 0) {
            int pickedAmount = coinPicker.pick(amount);
            amount -= pickedAmount;
            putCoin(pickedAmount);
        }
    }

    private void putCoin(int pickedAmount) {
        coins.keySet().stream()
                .filter(coin -> coin.getAmount() == pickedAmount)
                .findFirst()
                .ifPresent(coin -> coins.replace(coin, coins.get(coin)+1));
    }

    public void restockItem(Item item, int quantity) {
        items.put(item, quantity);
    }

    public boolean hasItem(String name) {
        return items.keySet().stream()
                .anyMatch(item -> Objects.equals(item.getName(), name));
    }
}
