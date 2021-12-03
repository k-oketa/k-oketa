package bridge.example;

public class Display {

    private final IDisplay display;

    public Display(IDisplay display) {
        this.display = display;
    }

    public void open() {
        display.rawOpen();
    }

    public void print() {
        display.rawPrint();
    }

    public void close() {
        display.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
