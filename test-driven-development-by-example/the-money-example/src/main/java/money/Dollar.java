package money;

public class Dollar {
    private final int amount;
    Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    public boolean equals(Object object) {
        var dollar = (Dollar) object;
        return amount == dollar.amount;
    }
}
