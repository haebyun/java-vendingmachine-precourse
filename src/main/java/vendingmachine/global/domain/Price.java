package vendingmachine.global.domain;

import vendingmachine.global.exception.CustomException;
import vendingmachine.global.exception.ErrorMessage;
import vendingmachine.global.validator.Validator;

public class Price {
    private static final int DIVISOR = 10;
    private static final int MIN_PRICE = 100;
    private final int price;

    private Price(int price) {
        validate(price);
        this.price = price;
    }

    public static Price valueOf(int price) {
        return new Price(price);
    }

    private void validate(int price) {
        Validator.validateDivisible(price, DIVISOR);
        validateRange(price);
    }

    private void validateRange(int price) {
        if (price < MIN_PRICE) {
            throw CustomException.from(ErrorMessage.MIN_PRICE_ERROR);
        }
    }

    public int getValue() {
        return price;
    }
}
