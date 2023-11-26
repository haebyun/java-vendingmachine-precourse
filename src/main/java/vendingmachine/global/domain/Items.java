package vendingmachine.global.domain;

import java.util.List;

public class Items {
    private List<Item> items;

    private Items(List<Item> items) {
        this.items = items;
    }

    public static Items from(List<Item> items) {
        return new Items(items);
    }
}
