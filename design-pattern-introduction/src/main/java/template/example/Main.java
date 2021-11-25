package template.example;

public class Main {

    public static void main(String[] args) {
        var d1 = new CharDisplay('H');
        var d2 = new StringDisplay("Hello, World.");

        d1.display();
        d2.display();
    }
}
