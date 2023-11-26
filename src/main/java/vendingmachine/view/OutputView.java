package vendingmachine.view;

import java.util.List;

public class OutputView {

    public void printErrorMessage (String message) {
        System.out.println(message);
    }

    public void printAvailableCoins(List<String> coins){
        coins.forEach(System.out::println);
    }
}
