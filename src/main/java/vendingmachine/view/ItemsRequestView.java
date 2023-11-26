package vendingmachine.view;

import vendingmachine.view.console.ConsoleReader;
import vendingmachine.view.console.ConsoleWriter;

public class ItemsRequestView {
    private static final String NOTICE = "상품명과 가격, 수량을 입력해 주세요.";

    public void requestItems() {
        ConsoleWriter.printlnMessage(NOTICE);
        String message = ConsoleReader.enterMessage();
        
    }
}
