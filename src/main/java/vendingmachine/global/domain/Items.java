package vendingmachine.global.domain;

import java.util.Comparator;
import java.util.List;
import vendingmachine.global.exception.CustomException;
import vendingmachine.global.exception.ErrorMessage;

public class Items {
    private List<Item> items;

    private Items(List<Item> items) {
        this.items = items;
    }

    public static Items from(List<Item> items) {
        return new Items(items);
    }

    public int getLeastPrice() {
        return items.stream()
                .map(Item::getPrice)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalStateException());
    }

    public Item sell(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                item.sell();
                return item;
            }
        }
        throw CustomException.from(ErrorMessage.UNKNOWN_ITEM_ERROR);
    }

    public boolean isSoldOut() {
        return items.stream()
                .allMatch(Item::isEmpty);
    }
}
