package adapter.extension.example;

public class Banner {

    private final String string;

    Banner(String string) {
        this.string = string;
    }

    void showWithParen() {
        System.out.println("(" + string + ")");
    }

    void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
