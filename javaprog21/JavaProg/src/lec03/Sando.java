package lec03;

public class Sando {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 3 == 0) {
                System.out.println("3の倍数！");
            } else {
                System.out.println(i);
            }
        }
    }
}
