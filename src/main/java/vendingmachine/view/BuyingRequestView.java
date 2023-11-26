package vendingmachine.view;

import vendingmachine.view.console.ConsoleReader;
import vendingmachine.view.console.ConsoleWriter;

public class BuyingRequestView {
    private static final String NOTICE = "구매할 상품명을 입력해 주세요.";
    private static final String PAYMENT_FORMAT = "투입 금액 : %d원";

    public static String requestBuyingItem(int payment) {
        ConsoleWriter.printlnFormat(PAYMENT_FORMAT, payment);

        ConsoleWriter.printlnMessage(NOTICE);
        return ConsoleReader.enterMessage();
    }
}
