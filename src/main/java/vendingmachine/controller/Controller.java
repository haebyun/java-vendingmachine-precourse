package vendingmachine.controller;

import java.util.List;
import java.util.stream.Stream;
import vendingmachine.domain.Item;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.OrderService;
import vendingmachine.util.Converter;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final Converter converter;
    private VendingMachine vendingMachine;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
        converter = new Converter();
    }

    public void prepareVendingMachine() {
        int availableBalance = setAvailableBalance();
        vendingMachine = new VendingMachine(availableBalance);
        outputView.printAvailableCoins(vendingMachine.getCoinHoldingsInformation());
        restockItems(setRestocks());
    }

    private void restockItems(List<String> restocks) {
        restocks.forEach(restock -> {
            List<String> information = Stream.of(restock.split("[,\\[\\]]"))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList();
            Item item = new Item(information.get(0), Integer.parseInt(information.get(1)));
            int quantity = Integer.parseInt(information.get(2));
            vendingMachine.restockItem(item, quantity);
        });
    }

    private int setAvailableBalance() {
        try {
            String input = inputView.readAvailableBalance();
            return converter.convertAvailableBalance(input);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return setAvailableBalance();
        }
    }

    private List<String> setRestocks() {
        try {
            String input = inputView.readRestock();
            return converter.convertRestocks(input);
        } catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return setRestocks();
        }
    }

    public void order(){
        OrderService orderService = new OrderService(vendingMachine);
        int insertAmount = setInsertAmount();
        while(true){
            insertAmount = deliverOrder(orderService, insertAmount);
            if(orderService.isDone(insertAmount)){
                outputView.printAvailableBalance(insertAmount);
                outputView.printChangesInformation(
                        orderService.getChangesInformation(insertAmount));
                break;
            }
        }
    }

    private int deliverOrder(OrderService orderService, int insertAmount) {
        try {
            outputView.printAvailableBalance(insertAmount);
            String itemName = inputView.readProductPurchase();
            return orderService.deliverOrder(itemName, insertAmount);
        } catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return deliverOrder(orderService, insertAmount);
        }
    }

    private int setInsertAmount() {
        try {
            String input = inputView.readInsertAmount();
            return converter.convertInsertAmount(input);
        } catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            return setInsertAmount();
        }
    }
}
