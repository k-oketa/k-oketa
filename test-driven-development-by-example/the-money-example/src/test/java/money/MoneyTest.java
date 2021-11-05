package money;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    @Test
    void testMultiplication() {
        var five = new Dollar(5);
        var product = five.times(2);
        assertEquals(10, product.amount);
        product = five.times(3);
        assertEquals(15, product.amount);
    }

    @Test
    void testEquality() {
        var equals = new Dollar(5).equals(new Dollar(5));
        assertTrue(equals);
        var notEquals = new Dollar(5).equals(new Dollar(6));
        assertFalse(notEquals);
    }
}
