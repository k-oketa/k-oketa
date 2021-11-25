package template.example;

public class StringDisplay implements AbstractDisplay {

    private final String string;
    private final int width;

    StringDisplay(String string) {
        this.string = string;
        this.width = string.length();
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (var i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
