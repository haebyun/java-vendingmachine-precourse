package vendingmachine.view;

import vendingmachine.view.console.ConsoleWriter;

public final class ChangeResponseView {

    private static final String NOTICE = "잔돈";
    private static final String PAYMENT_FORMAT = "투입 금액 : %d원";
    private static final String COIN_RESPONSE_FORMAT = "%d원 - %d개";

    public static void printChange(int remain, ) {
        ConsoleWriter.printlnFormat(PAYMENT_FORMAT, remain);
        ConsoleWriter.printlnMessage(NOTICE);
    }
}
