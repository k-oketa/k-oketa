package bridge.example;

public class CountDisplay extends Display {

    public CountDisplay(IDisplay display) {
        super(display);
    }

    public void multiDisplay(int times) {
        open();
        for (var i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
