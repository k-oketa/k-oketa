package lec05;

public class Comparison {

    int getMax(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    int getMin(int a, int b) {
        if (a <= b) {
            return a;
        }
        return b;
    }

    void compare(int a, int b) {
        Comparison comp = new Comparison();
        int max = comp.getMax(a, b);
        int min = comp.getMin(a, b);

        System.out.println("大きいのは " + max);
        System.out.println("小さいのは " + min);
    }
}
