package vendingmachine.global.domain;

public class Payment {
    private int payment;

    private Payment(int payment) {
        this.payment = payment;
    }

    public static Payment valueOf(int payment) {
        return new Payment(payment);
    }

    public int getValue() {
        return payment;
    }
}
