package vendingmachine.view;

import vendingmachine.global.validator.Validator;
import vendingmachine.view.console.ConsoleReader;
import vendingmachine.view.console.ConsoleWriter;

public class PaymentInputView {
    private static final String message = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final int DIVISOR = 10;

    public int requestPayment() {
        ConsoleWriter.printlnMessage(message);
        String payment = ConsoleReader.enterMessage();
        return validate(payment);
    }

    private int validate(String input) {
        Validator.validatePositiveNumber(input);
        int payment = Integer.parseInt(input);
        Validator.validateDivisible(payment, DIVISOR);
        return payment;
    }
}
