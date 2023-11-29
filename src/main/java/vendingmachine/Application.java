package vendingmachine;

import vendingmachine.controller.Controller;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller vendingMachineController = new Controller();
        vendingMachineController.prepareVendingMachine();
        vendingMachineController.order();
    }
}
