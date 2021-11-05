package money;

import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    void testMultiplication() {
        var five = new Doller(5);
        five.times(2);
        assertEquals(10, five.amount);
    }
}
