package vendingmachine.view;

import vendingmachine.global.validator.Validator;
import vendingmachine.view.console.ConsoleReader;
import vendingmachine.view.console.ConsoleWriter;

public final class AmountInputView {
    private static final String message = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final int DIVISOR = 10;

    public static int requestAmount() {
        ConsoleWriter.printlnMessage(message);
        String amount = ConsoleReader.enterMessage();
        return validate(amount);
    }

    private static int validate(String input) {
        Validator.validatePositiveNumber(input);
        int amount = Integer.parseInt(input);
        Validator.validateDivisible(amount, DIVISOR);
        return amount;
    }
}
