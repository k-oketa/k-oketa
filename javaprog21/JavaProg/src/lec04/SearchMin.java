package lec04;

import java.util.Scanner;

public class SearchMin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            System.out.print("整数を入力してください: ");
            int n = input.nextInt();
            a[i] = n;
        }

        int min = a[0];
        for (int j = 1; j < a.length; j++) {
            if (min > a[j]) {
                min = a[j];
            }
        }
        System.out.println("最小値は: " + min);
    }
}
