package lec12;

import lec12.mob.Enemy;
import lec12.mob.Player;
import lec12.trump.DeckFactory;

import java.util.Scanner;

public class SimpleBlackJack {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var player = new Player();
        var enemy = new Enemy();

        var deck = DeckFactory.deck();
        deck.shuffle();

        deck = player.drawTwoCards(deck, scanner);
        deck = enemy.drawTwoCards(deck, null);
        System.out.println("あなた: 合計 " + player.getHand().sum() + "(" + player.getHand().toString() + ")");
        System.out.println("あいて: 合計 " + enemy.getHand().sum() + "(" + enemy.getHand().toString() + ")");

        scanner.close();
    }
}
