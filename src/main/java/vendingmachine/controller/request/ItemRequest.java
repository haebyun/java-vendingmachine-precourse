package vendingmachine.controller.request;

public record ItemRequest(
        String name,
        int price,
        int count
) {
}
