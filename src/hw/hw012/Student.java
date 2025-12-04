package hw.hw012;

public class Student {
    private final Direction direction;
    private final int requiredCredits;
    private int money;
    private int earnedCredits;
    private boolean expelled;

    public Student(Direction direction, int requiredCredits, int startingMoney) {
        this.direction = direction;
        this.requiredCredits = requiredCredits;
        this.money = startingMoney;
        this.earnedCredits = 0;
        this.expelled = false;
    }

    public void accept(StudentVisitor visitor) {
        visitor.visit(this);
    }

    public Direction getDirection() {
        return direction;
    }

    public int getMoney() {
        return money;
    }

    public int getEarnedCredits() {
        return earnedCredits;
    }

    public boolean isExpelled() {
        return expelled;
    }

    public void expel() {
        this.expelled = true;
    }

    public void addCredits(int credits) {
        earnedCredits += credits;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public boolean pay(int amount) {
        if (money < amount) {
            expel();
            return false;
        }
        money -= amount;
        return true;
    }

    public boolean canGraduate() {
        return !expelled && earnedCredits >= requiredCredits;
    }
}

