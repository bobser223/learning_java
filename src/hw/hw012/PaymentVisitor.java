package hw.hw012;

public class PaymentVisitor implements StudentVisitor {
    private final int amount;

    public PaymentVisitor(int amount) {
        this.amount = amount;
    }

    @Override
    public void visit(Student student) {
        if (student.isExpelled()) {
            return;
        }
        student.pay(amount);
    }
}

