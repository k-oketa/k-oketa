package lec12.trump;

public class DeckFactory {
    public static Deck deck() {
        var deck = new Deck();
        for (var mark: Mark.values()) {
            for (var number: Number.values()) {
                var card = new Card(mark, number);
                deck.add(card);
            }
        }
        return deck;
    }
}
