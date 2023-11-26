package vendingmachine.global.controller.dto.response;

import java.util.Map;
import vendingmachine.Coin;

public record ChangeResponse(
        Map<Coin, Integer> coins
) {
}
