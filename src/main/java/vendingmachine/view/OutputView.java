package vendingmachine.view;

import java.util.List;
import java.util.Map;
import vendingmachine.domain.Coin;

public class OutputView {

    public void printErrorMessage (String message) {
        System.out.println(message);
        System.out.println();
    }

    public void printAvailableCoins(List<String> coins){
        System.out.println("자판기가 보유한 동전");
        coins.forEach(System.out::println);
    }

    public void printAvailableBalance(int balance) {
        System.out.println("투입 금액: " + balance + "원");
    }

    public void printChangesInformation(Map<Coin, Integer> changesInformation) {
        System.out.println("잔돈");
        changesInformation.entrySet().stream()
                .sorted((coin1, coin2) -> Integer.compare(coin2.getKey().getAmount(), coin1.getKey().getAmount()))
                .forEach(entry -> System.out.println(entry.getKey().getAmount() + "원 - " + entry.getValue() + "개"));
    }
}
