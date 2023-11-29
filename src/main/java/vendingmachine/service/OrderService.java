package vendingmachine.service;

import java.util.List;
import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.util.VendingMachineException;

public class OrderService {
    private final VendingMachine vendingMachine;

    public OrderService(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public int deliverOrder(String itemName, int insertAmount) {
        Item orderItem = vendingMachine.findItem(itemName);
        validateOverPrice(orderItem, insertAmount);
        vendingMachine.applyOrder(orderItem);
        return insertAmount - orderItem.getPrice();
    }

    private void validateOverPrice(Item orderItem, int insertAmount) {
        if (orderItem.getPrice() > insertAmount) {
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
    }

    public boolean isDone(int insertAmount) {
        return vendingMachine.isAllOutOfStock()
                || vendingMachine.getMinimumItemPrice() > insertAmount;
    }

    public Map<Coin, Integer> getChangesInformation(int insertAmount) {
        return vendingMachine.makeChanges(insertAmount);
    }
}
