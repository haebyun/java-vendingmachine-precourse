package vendingmachine.global.controller;

import java.util.function.Supplier;
import vendingmachine.global.domain.Amount;
import vendingmachine.global.domain.VendingMachine;
import vendingmachine.view.AmountRequestView;
import vendingmachine.view.CoinsResponseView;
import vendingmachine.view.console.ConsoleWriter;

public class VendingMachineController {

    public void run() {
        VendingMachine vendingMachine = initialize();
        CoinsResponseView.print(vendingMachine.toCoinsResponse());
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
