package lec03;

import java.util.Scanner;

public class Addition {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("a: ");
        float a = input.nextFloat();
        System.out.print("b: ");
        float b = input.nextFloat();

        float ans = a + b;
        System.out.println("a + b = " + ans);
    }
}
