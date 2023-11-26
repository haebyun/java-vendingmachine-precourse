package vendingmachine.util;

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
        if(balance%10>0){
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
        if(balance<0){
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
    }
}
