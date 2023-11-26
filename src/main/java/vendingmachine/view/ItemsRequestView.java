package vendingmachine.view;

import java.util.Arrays;
import java.util.List;
import vendingmachine.global.exception.CustomException;
import vendingmachine.global.exception.ErrorMessage;
import vendingmachine.view.console.ConsoleReader;
import vendingmachine.view.console.ConsoleWriter;

public class ItemsRequestView {
    private static final String NOTICE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String REGEX = "\\[[^,]+,\\d+,\\d+\\]";
    private static final String SEPARATOR = ";";


    public static void requestItems() {
        ConsoleWriter.printlnMessage(NOTICE);
        validate(ConsoleReader.enterMessage());
    }

    private static void validate(String input) {
        List<String> items = split(input);
        validateFormat(items);
    }

    private static List<String> split(String input) {
        return Arrays.stream(input.split(SEPARATOR))
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


}
