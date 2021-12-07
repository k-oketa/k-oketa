package lec12.trump;

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Card> {

    Deck() {}

    public Card draw(int index) {
        var card = this.get(index);
        this.remove(index);
        return card;
    }

    public Range range() {
        return new Range(0, this.size());
    }

    public void shuffle() {
        Collections.shuffle(this);
    }
}
