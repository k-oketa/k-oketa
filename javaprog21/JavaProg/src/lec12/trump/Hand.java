package lec12.trump;

import java.util.ArrayList;

public class Hand extends ArrayList<Card> {

    public int sum() {
        var sum = 0;
        for (var card: this) {
            sum += card.number().getValue();
        }
        return sum;
    }
}
