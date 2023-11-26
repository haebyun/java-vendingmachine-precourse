package vendingmachine.global.controller.dto.response;

import java.util.List;

public record CoinsResponse(
        List<CoinResponse> responses
) {
}
