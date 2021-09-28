package lec03;

public class MultiTable {

    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            System.out.print(i + "の段\t");
            for (int j = 1; j <= 9; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println("");
        }
    }
}
