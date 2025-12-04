package hw.hw012;

public class MoneyIncomeVisitor implements StudentVisitor {
    private final int amount;

    public MoneyIncomeVisitor(int amount) {
        this.amount = amount;
    }

    @Override
    public void visit(Student student) {
        if (student.isExpelled()) {
            return;
        }
        student.addMoney(amount);
    }
}

