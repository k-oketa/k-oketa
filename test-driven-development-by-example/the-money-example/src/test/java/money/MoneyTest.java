package money;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    @Test
    void testMultiplication() {
        var five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));

        assertFalse(Money.dollar(5).equals(Money.franc(5)));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    void testSimpleAddition() {
        var five = Money.dollar(5);
        var sum = five.plus(five);
        var bank = new Bank();
        var reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    void testPlusReturnsSum() {
        var five = Money.dollar(5);
        var result = five.plus(five);
        var sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    void testReduceSum() {
        var sum = new Sum(Money.dollar(3), Money.dollar(4));
        var bank = new Bank();
        var result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    void testReduceMoney() {
        var bank = new Bank();
        var result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    void testReduceMoneyDifferentCurrency() {
        var bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        var result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    void testMixedAddition() {
        var fiveBucks = Money.dollar(5);
        var tenFrancs = Money.franc(10);
        var bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        var result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }

    @Test
    void testSumPlusMoney() {
        var fiveBucks = Money.dollar(5);
        var tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        var sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        var result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);
    }

    @Test
    void testSumTimes() {
        var fiveBucks = Money.dollar(5);
        var tenFrancs = Money.franc(10);
        var bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        var sum = new Sum(fiveBucks, tenFrancs).times(2);
        var result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }
}
