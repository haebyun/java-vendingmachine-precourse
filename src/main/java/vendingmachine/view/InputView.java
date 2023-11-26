package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.VendingMachineException;

public class InputView {
    private static final String AVAILABLE_BALANCE_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String RESTOCK_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INSERT_AMOUNT_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String PRODUCT_PURCHASE_MESSAGE = "구매할 상품명을 입력해 주세요.";

    public String readAvailableBalance() {
        System.out.println(AVAILABLE_BALANCE_MESSAGE);
        String input = Console.readLine();
        validateEmptyInput(input);
        return input;
    }

    public String readRestock() {
        System.out.println(RESTOCK_MESSAGE);
        String input = Console.readLine();
        validateEmptyInput(input);
        return input;
    }

    public String readInsertAmount() {
        System.out.println(INSERT_AMOUNT_MESSAGE);
        String input = Console.readLine();
        validateEmptyInput(input);
        return input;
    }

    public String readProductPurchase() {
        System.out.println(PRODUCT_PURCHASE_MESSAGE);
        String input = Console.readLine();
        validateEmptyInput(input);
        return input;
    }

    private void validateEmptyInput(String input){
        if(input.isEmpty()) {
            throw new IllegalArgumentException(VendingMachineException.INVALID_INPUT.getMessage());
        }
    }
}
