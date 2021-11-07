package money;

public class Bank {
    Money reduce(Expression source, String to) {
        var sum = (Sum) source;
        return sum.reduce(to);
    }
}
