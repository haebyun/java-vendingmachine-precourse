package vendingmachine.global.validator;

import vendingmachine.global.exception.CustomException;
import vendingmachine.global.exception.ErrorMessage;

public final class Validator {
    public static void validatePositiveNumber(String input) {
        if (isNotNumber(input)) {
            throw CustomException.from(ErrorMessage.NOT_NUMBER_ERROR);
        }
    }

    private static boolean isNotNumber(String input) {
        return input.matches("\\d+");
    }
}
