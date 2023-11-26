package vendingmachine.controller.request;

import java.util.List;

public record ItemsRequest(
        List<ItemRequest> requests
) {
}
