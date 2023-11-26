package vendingmachine.global.exception;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NOT_NUMBER_ERROR("올바른 숫자를 입력해주세요."),
    SEPARATOR_ERROR("올바른 구분자를 사용해 입력해주세요."),
    UNKNOWN_ITEM_ERROR("존재하지 않는 상품입니다."),
    CANNOT_BUY_ERROR("금액이 부족하여 상품을 구매할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
