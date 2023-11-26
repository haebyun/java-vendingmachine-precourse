package vendingmachine.global.controller;

import vendingmachine.global.domain.Amount;
import vendingmachine.global.domain.VendingMachine;
import vendingmachine.view.AmountRequestView;

public class VendingMachineController {

    public void run() {
        initialize();
    }

    private VendingMachine initialize() {
        Amount amount = Amount.from(AmountRequestView.requestAmount());
        return VendingMachine.of(amount);
    }
}
