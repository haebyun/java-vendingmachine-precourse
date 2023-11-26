package vendingmachine.service;

import java.util.List;
import java.util.stream.Stream;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;

public class VendingMachineService {
    private VendingMachine vendingMachine;

    public void startVendingMachine(int availableBalance) {
        vendingMachine = new VendingMachine(availableBalance);
    }

    public List<String> getFormalizedCoins() {
        return vendingMachine.getCoinHoldings();
    }

    public void restockItems(List<String> restocks) {
        restocks.forEach(restock -> {
            List<String> information = Stream.of(restock.split("[,\\[\\]]"))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList();
            Item item = new Item(information.get(0), Integer.parseInt(information.get(1)));
            int quantity = Integer.parseInt(information.get(2));
            vendingMachine.restockItem(item, quantity);
        });
    }
}
