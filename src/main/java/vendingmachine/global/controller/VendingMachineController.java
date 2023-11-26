package vendingmachine.global.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import vendingmachine.controller.request.ItemRequest;
import vendingmachine.controller.request.ItemsRequest;
import vendingmachine.global.domain.Amount;
import vendingmachine.global.domain.Item;
import vendingmachine.global.domain.Items;
import vendingmachine.global.domain.VendingMachine;
import vendingmachine.view.AmountRequestView;
import vendingmachine.view.CoinsResponseView;
import vendingmachine.view.ItemsRequestView;
import vendingmachine.view.console.ConsoleWriter;

public class VendingMachineController {

    public void run() {
        VendingMachine vendingMachine = initialize();
        CoinsResponseView.print(vendingMachine.toCoinsResponse());

        Items items = generateItems(ItemsRequestView.requestItems());

        
    }

    private Items generateItems(ItemsRequest itemsRequest) {
        List<Item> items = new ArrayList<>();
        for (ItemRequest itemRequest : itemsRequest.requests()) {
            Item item = Item.of(
                    itemRequest.name(),
                    itemRequest.price(),
                    itemRequest.count()
            );
            items.add(item);
        }
        return Items.from(items);
    }

    private VendingMachine initialize() {
        Amount amount = retry(() -> {
            return Amount.from(AmountRequestView.requestAmount());
        });
        return VendingMachine.of(amount);
    }

    private static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                ConsoleWriter.printlnMessage(e.getMessage());
            }
        }
    }
}
