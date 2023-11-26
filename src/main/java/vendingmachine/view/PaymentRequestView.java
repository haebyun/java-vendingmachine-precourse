package vendingmachine.view;

import vendingmachine.global.validator.Validator;
import vendingmachine.view.console.ConsoleReader;
import vendingmachine.view.console.ConsoleWriter;

public final class PaymentRequestView {
    private static final String NOTICE = "투입 금액을 입력해 주세요.";

    public static int requestPayment() {
        ConsoleWriter.printlnMessage(NOTICE);
        return validate(ConsoleReader.enterMessage());
    }

    private static int validate(String input) {
        Validator.validatePositiveNumber(input);
        return Integer.parseInt(input);
    }
}
