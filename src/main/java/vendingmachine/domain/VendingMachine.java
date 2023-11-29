package vendingmachine.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import vendingmachine.util.CoinPicker;
import vendingmachine.util.VendingMachineException;

public class VendingMachine {
    private final Map<Coin, Integer> coins = new HashMap<>();
    private final Map<Item, Integer> items = new HashMap<>();
    private final CoinPicker coinPicker = new CoinPicker();
    private int changeNotReturned = 0;

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
        Coin pickedCoin = Coin.findCoinByAmount(pickedAmount);
        coins.replace(pickedCoin, coins.get(pickedCoin) + 1);
    }

    public List<String> getCoinHoldingsInformation() {
        return coins.keySet().stream()
                .sorted((coin1, coin2) -> Integer.compare(coin2.getAmount(), coin1.getAmount()))
                .map(coin -> coin.getAmount() + "원 - " + coins.get(coin) + "개")
                .collect(Collectors.toList());
    }

    public void restockItem(Item item, int quantity) {
        items.put(item, quantity);
    }

    public boolean isAllOutOfStock() {
        return items.isEmpty();
    }

    public Item findItem(String itemName) {
        return items.keySet().stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage()));
    }

    public void applyOrder(Item orderItem) {
        items.replace(orderItem, items.get(orderItem) - 1);
        if (items.get(orderItem) == 0) {
            items.remove(orderItem);
        }
    }

    public int getMinimumItemPrice() {
        return items.keySet()
                .stream()
                .mapToInt(Item::getPrice)
                .min()
                .orElse(-1);
    }

    public Map<Coin, Integer> makeChanges(int insertAmount) {
        Map<Coin, Integer> changes = Coin.getChangeInformation(coins, insertAmount);
        updateNotReturned(changes, insertAmount);
        changes.forEach((key, value) -> {
            coins.replace(key, coins.get(key) - value);
        });
        return changes;
    }

    private void updateNotReturned(Map<Coin, Integer> changes, int insertAmount) {
        int totalChange = changes.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getAmount() * entry.getValue())
                .sum();
        changeNotReturned += (insertAmount - totalChange);
    }
}
