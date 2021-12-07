package lec12.mob;

import lec12.trump.Deck;
import lec12.trump.Hand;
import lec12.trump.Range;

import java.util.Scanner;

public abstract class Mob {

    private final Hand hand;

    public Mob() {
        this.hand = new Hand();
    }

    public Deck drawTwoCards(Deck deck, Scanner scanner) {
        var first = this.choiceIndex(deck.range(), scanner);
        this.hand.add(deck.draw(first));
        var second = this.choiceIndex(deck.range(), scanner);
        this.hand.add(deck.draw(second));
        return deck;
    }

    public abstract int choiceIndex(Range range, Scanner scanner);

    public Hand getHand() {
        return this.hand;
    }
}
