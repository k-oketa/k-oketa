package adapter.question;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        var f = new FileProperties();
        try {
            f.readFromFile("./file.txt");
            f.setValue("width", "1024");
            f.setValue("height", "512");
            f.setValue("depth", "32");
            f.writeToFile("./newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
