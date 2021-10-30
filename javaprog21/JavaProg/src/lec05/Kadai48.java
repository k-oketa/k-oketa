package lec05;

import java.util.Scanner;

public class Kadai48 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        Hantei hantei = new Hantei();
        String result = hantei.evenOrOdd(n);
        System.out.print(result);
    }
}
