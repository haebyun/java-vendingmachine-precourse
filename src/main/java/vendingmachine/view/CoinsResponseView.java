package vendingmachine.view;

import vendingmachine.global.controller.dto.response.CoinsResponse;
import vendingmachine.view.console.ConsoleWriter;

public class CoinsResponseView {
    private static final String message = "자판기가 보유한 동전";

    public void print(CoinsResponse coinsResponse) {
        ConsoleWriter.printlnMessage(message);

    }
}
