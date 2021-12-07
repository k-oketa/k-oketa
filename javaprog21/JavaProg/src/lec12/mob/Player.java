package lec12.mob;

import lec12.trump.Range;

import java.util.Scanner;

public class Player extends Mob {

    @Override
    public int choiceIndex(Range range, Scanner scanner) {
        System.out.print("デッキの要素番号を入力してください(" + range.from() + " ~ " + range.to() + "): ");
        return scanner.nextInt();
    }
}
