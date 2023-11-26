package vendingmachine.global.domain;

public class CoinCount {
    private int count;

    private CoinCount(int count) {
        this.count = count;
    }

    public CoinCount valueOf(int count) {
        return new CoinCount(count);
    }
}
