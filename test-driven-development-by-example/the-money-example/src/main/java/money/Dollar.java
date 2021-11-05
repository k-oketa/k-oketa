package money;

public class Dollar {
    int amount;
    Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier) {
        amount = amount * multiplier;
        return null;
    }
}
