package adapter.extension.example;

public class Main {

    public static void main(String[] args) {
        var p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
