package vendingmachine.view;

import java.util.List;

public class OutputView {

    public void printErrorMessage (String message) {
        System.out.println(message);
        System.out.println();
    }

    public void printAvailableCoins(List<String> coins){
        coins.forEach(System.out::println);
    }

    public void printAvailableBalance(int balance) {
        System.out.println("투입 금액: " + balance);
    }
}
