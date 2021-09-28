package lec03;

import java.io.IOException;

public class Reader {
    public static void main(String[] args) throws IOException {
        System.out.print("何かキーを押してください: ");
        int a = System.in.read(); // 入力したキーのバイトを取得
        System.out.println(a);
        a = System.in.read();
        System.out.println(a);
        // ScannerはSystem.in.read()から取得したバイトを文字（nextIntなら数字、nextなら文字列のように）に変換する役割
    }
}
