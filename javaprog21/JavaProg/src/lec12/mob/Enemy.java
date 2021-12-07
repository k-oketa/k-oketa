package lec12.mob;

import lec12.trump.Range;

import java.util.Random;
import java.util.Scanner;

public class Enemy extends Mob {
    @Override
    public int choiceIndex(Range range, Scanner scanner) {
        var generator = new Random(42);
        return generator.nextInt(range.to());
    }
}
