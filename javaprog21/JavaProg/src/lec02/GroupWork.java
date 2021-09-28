package lec02;

public class GroupWork {

    public static void main(String[] args) {
        long a = 2L;
        double b =  0.9d;
        double c = 1.0d;
        float d = 0.9f;

        // longでキャストすることで1.1の小数点以下を切り捨てる
        long longAns = (long) (a - b);
        // 無限小数による誤差が生じる
        double doubleAns1 = c - b;
        // 桁数による誤差が生じる
        double doubleAns2 = c - d;

        System.out.println(longAns);
        System.out.println(doubleAns1);
        System.out.println(doubleAns2);
    }
}
