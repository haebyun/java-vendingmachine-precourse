package vendingmachine.global.controller;

import vendingmachine.global.domain.Amount;
import vendingmachine.view.AmountInputView;

public class VendingMachine {
    public void run() {
        initialize();
    }

    private void initialize() {
        Amount payment = Amount.from(AmountInputView.requestAmount());

    }
}
