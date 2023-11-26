package vendingmachine.service;

import java.util.List;
import vendingmachine.domain.VendingMachine;

public class VendingMachineService {
    private VendingMachine vendingMachine;

    public void startVendingMachine(int availableBalance) {
        vendingMachine = new VendingMachine(availableBalance);
    }

    public List<String> getFormalizedCoins() {
        return vendingMachine.getCoinHoldings();
    }
}
