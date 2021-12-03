package bridge.example;

public class Main {

    public static void main(String[] args) {
        var d1 = new Display(new StringDisplay("Hello Japan"));
        var d2 = new CountDisplay(new StringDisplay("Hello World"));
        var d3 = new CountDisplay(new StringDisplay("Hello, Universe"));
        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }
}
