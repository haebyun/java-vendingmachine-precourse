package vendingmachine.util;

import java.util.List;
import java.util.stream.Stream;

public class Converter {

    public int convertAvailableBalance(String input) {
        try {
            int balance = Integer.parseInt(input);
            validateInvalidBalance(balance);
            return balance;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
    }

    private void validateInvalidBalance(int balance) {
        if (balance % 10 > 0) {
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
        if (balance < 0) {
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
    }

    public List<String> convertRestocks(String input) {
        try {
            List<String> restocks = Stream.of(input.split(";", -1))
                    .toList();
            restocks.forEach(this::validateRestocks);
            return restocks;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
    }

    private void validateRestocks(String restock) {
        List<String> information = Stream.of(restock.split("[,\\[\\]]"))
                .map(String::trim)
                .filter(s->!s.isEmpty())
                .toList();
        validateSize(information.size());
        int price = Integer.parseInt(information.get(1));
        validatePrice(price);
        int quantity = Integer.parseInt(information.get(2));
        validateQuantity(quantity);
    }

    private void validateSize(int size) {
        if (size != 3) {
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
    }

    private void validatePrice(int price) {
        if (price < 100) {
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
        if (price % 10 > 0) {
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
    }

    public int convertInsertAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            validateInsertAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
    }

    private void validateInsertAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
    }
}
