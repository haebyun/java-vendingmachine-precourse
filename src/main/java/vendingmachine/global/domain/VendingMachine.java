package vendingmachine.global.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import vendingmachine.Coin;
import vendingmachine.global.controller.dto.response.CoinsResponse;
import vendingmachine.global.exception.CustomException;
import vendingmachine.global.exception.ErrorMessage;

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
            validateCreationCoin(amount);

            Coin coin = getRandomCoin();
            coins.add(coin);
            amount -= coin.getAmount();
        }
    }

    private void validateCreationCoin(int amount) {
        if (isLessThanLeastCoin(amount)) {
            throw CustomException.from(ErrorMessage.CANNOT_CREATE_COIN);
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
}
