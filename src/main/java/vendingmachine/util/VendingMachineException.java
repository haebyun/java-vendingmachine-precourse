package vendingmachine.util;

public enum VendingMachineException {
    INVALID_INPUT("유효하지 않은 입력입니다. 다시 입력해 주세요.");
    private final String errorMessage;

    VendingMachineException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return "[ERROR] " + errorMessage;
    }
}
