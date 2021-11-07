package money;

public interface Expression {
    Money reduce(Bank bank, String to);
    Expression times(int multiplier);
}
