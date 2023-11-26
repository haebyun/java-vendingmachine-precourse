package vendingmachine.view;

import vendingmachine.view.console.ConsoleWriter;

public class BuyingRequestView {
    private static final String NOTICE = "구매할 상품명을 입력해 주세요.";

    public void requestBuyingItem() {
        ConsoleWriter.printlnMessage(NOTICE);

    }
}
