package lec05;

import java.util.Scanner;

public class Kadai45 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("a = ");
        int a = input.nextInt();
        System.out.print("b = ");
        int b = input.nextInt();

        Comparison comparison = new Comparison();
        comparison.compare(a, b);
    }
}
