package template.example;

public abstract class AbstractDisplay {

    abstract void open();
    abstract void print();
    abstract void close();

    public final void display() {
        open();
        for (var i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
