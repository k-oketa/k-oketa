package template.example;

public class StringDisplay extends AbstractDisplay {

    private final String string;
    private final int width;

    StringDisplay(String string) {
        this.string = string;
        this.width = string.length();
    }

    @Override
    protected void open() {
        printLine();
    }

    @Override
    protected void print() {
        System.out.println("|" + string + "|");
    }

    @Override
    protected void close() {
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
