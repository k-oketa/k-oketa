package lec03;

import java.io.IOException;

public class Reader {
    public static void main(String[] args) throws IOException {
        System.out.print("何かキーを押してください: ");
        int a = System.in.read(); // 入力したキーのバイトを取得
        System.out.println(a);
    }
}
