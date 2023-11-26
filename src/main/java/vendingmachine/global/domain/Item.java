package vendingmachine.global.domain;

public class Item {
    private String name;
    private Price price;
    private Count count;

    private Item(String name, Price price, Count count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public static Item of(String name, int price, int count) {
        return new Item(name, Price.valueOf(price), Count.valueOf(count));
    }

    public int getPrice() {
        return price.getValue();
    }

    public boolean isEmpty() {
        return count.isEqualTo(0);
    }

    public String getName() {
        return name;
    }

    public void sell() {
        count.subtract(1);
    }
}
