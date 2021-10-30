package lec05;

import java.util.Scanner;

public class Kadai44 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("a = ");
        int a = input.nextInt();
        System.out.print("b = ");
        int b = input.nextInt();

        Comparison comp = new Comparison();
        int max = comp.getMax(a, b);
        int min = comp.getMin(a, b);

        System.out.println("大きいのは " + max);
        System.out.println("小さいのは " + min);
    }
}
