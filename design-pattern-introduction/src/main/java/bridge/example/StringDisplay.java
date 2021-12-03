package bridge.example;

public class StringDisplay extends IDisplay {

    private final String string;
    private final int width;

    public StringDisplay(String string) {
        this.string = string;
        this.width = string.length();
    }

    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|");
    }

    @Override
    public void rawClose() {
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
