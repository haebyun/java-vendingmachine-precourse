package vendingmachine.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import vendingmachine.controller.request.ItemRequest;
import vendingmachine.controller.request.ItemsRequest;
import vendingmachine.global.exception.CustomException;
import vendingmachine.global.exception.ErrorMessage;
import vendingmachine.global.validator.Validator;
import vendingmachine.view.console.ConsoleReader;
import vendingmachine.view.console.ConsoleWriter;

public class ItemsRequestView {
    private static final String NOTICE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String REGEX = "\\[[^,]+,\\d+,\\d+\\]";
    private static final String ITEMS_SEPARATOR = ";";
    private static final String ITEM_SEPARATOR = ",";

    public static ItemsRequest requestItems() {
        ConsoleWriter.printlnMessage(NOTICE);
        String input = ConsoleReader.enterMessage();
        List<String> items = validate(input);
        return toItemsRequest(items);
    }

    private static List<String> validate(String input) {
        List<String> items = split(input);
        validateFormat(items);
        return items;
    }

    private static List<String> split(String input) {
        return Arrays.stream(input.split(ITEMS_SEPARATOR))
                .map(String::trim)
                .toList();
    }

    private static void validateFormat(List<String> items) {
        if (hasInvalidFormat(items)) {
            throw CustomException.from(ErrorMessage.SEPARATOR_ERROR);
        }
    }

    private static boolean hasInvalidFormat(List<String> items) {
        return !items.stream()
                .allMatch(item -> item.matches(REGEX));

        //    Pattern pattern = Pattern.compile(BEVERAGE_FORMAT_REGEX);
        //        Matcher matcher = pattern.matcher(input);
    }

    private static ItemsRequest toItemsRequest(List<String> items) {
        List<ItemRequest> itemRequests = new ArrayList<>();
        for (String item : items) {
            itemRequests.add(toItemRequest(item));
        }
        return new ItemsRequest(itemRequests);
    }

    private static ItemRequest toItemRequest(String input) {
        String[] parts = input.substring(1, input.length() - 1).split(ITEM_SEPARATOR);
        String name = parts[0];
        String price = parts[1];
        String quantity = parts[2];

        Validator.validatePositiveNumber(price);
        Validator.validatePositiveNumber(quantity);

        return new ItemRequest(
                name,
                Integer.parseInt(price),
                Integer.parseInt(quantity)
        );
    }
}
