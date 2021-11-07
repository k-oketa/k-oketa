package money;

public class Money {
    protected int amount;

    public boolean equals(Object object) {
        var money = (Money) object;
        return amount == money.amount && getClass().equals(money.getClass());
    }
}
