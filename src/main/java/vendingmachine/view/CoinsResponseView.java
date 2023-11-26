package vendingmachine.view;

import java.util.List;
import vendingmachine.global.controller.dto.response.CoinResponse;
import vendingmachine.global.controller.dto.response.CoinsResponse;
import vendingmachine.view.console.ConsoleWriter;

public final class CoinsResponseView {
    private static final String NOTICE = "자판기가 보유한 동전";
    private static final String COIN_RESPONSE_FORMAT = "%d원 - %d개";

    public static void print(CoinsResponse coinsResponse) {
        ConsoleWriter.printlnMessage(NOTICE);
        printCoinResponses(coinsResponse.responses());
    }

    private static void printCoinResponses(List<CoinResponse> responses) {
        responses.forEach(
                response -> ConsoleWriter.printlnFormat(
                        COIN_RESPONSE_FORMAT,
                        response.amount(),
                        response.count()
                )
        );
    }
}
