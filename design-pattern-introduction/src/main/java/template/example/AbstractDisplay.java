package template.example;

public interface AbstractDisplay {

    void open();
    void print();
    void close();

    default void display() {
        open();
        for (var i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
