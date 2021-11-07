package money;

abstract class Money {
    protected int amount;
    protected String currency;

    abstract Money times(int multiplier);

    public boolean equals(Object object) {
        var money = (Money) object;
        return amount == money.amount && getClass().equals(money.getClass());
    }

    String currency() {
        return currency;
    }

    static Dollar dollar(int amount) {
        return new Dollar(amount);
    }

    static Franc franc(int amount) {
        return new Franc(amount);
    }
}
