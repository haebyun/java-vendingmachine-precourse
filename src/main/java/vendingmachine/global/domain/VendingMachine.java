package vendingmachine.global.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import vendingmachine.Coin;
import vendingmachine.global.controller.dto.response.ChangeResponse;
import vendingmachine.global.controller.dto.response.CoinsResponse;

public class VendingMachine {
    private Coins coins;
    private Amount amount;

    private VendingMachine(Amount amount) {
        coins = new Coins();
        generateCoins(amount.getValue());
        this.amount = amount;
    }

    public static VendingMachine of(Amount amount) {
        return new VendingMachine(amount);
    }

    private void generateCoins(int amount) {
        while (amount > 0) {
            // 더 이상 동전을 만들 수 없는 경우
            if (isLessThanLeastCoin(amount)) {
                break;
            }
            Coin coin = getRandomCoin();
            coins.add(coin);
            amount -= coin.getAmount();
        }
    }

    private boolean isLessThanLeastCoin(int amount) {
        return amount < Coin.getLeastAmount();
    }

    private Coin getRandomCoin() {
        List<Integer> coinAmounts = Coin.toAmounts();
        int coinAmount = Randoms.pickNumberInList(coinAmounts);
        return Coin.valueOf(coinAmount);
    }

    public CoinsResponse toCoinsResponse() {
        return coins.toCoinsResponse();
    }

    public ChangeResponse changeCoins(int remain) {
        if (amount.getValue() < remain) {
            amount = Amount.from(remain - amount.getValue());
            return coins.toChangeResponse();
        }

    }
}
