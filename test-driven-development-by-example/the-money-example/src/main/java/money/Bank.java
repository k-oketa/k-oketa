package money;

public class Bank {
    Money reduce(Expression source, String to) {
        var sum = (Sum) source;
        int amount = sum.augend.amount + sum.addend.amount;
        return new Money(amount, to);
    }
}
