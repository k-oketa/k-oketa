package adapter.question;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO {

    @Override
    public void readFromFile(String filename) throws IOException {
        super.load(new FileReader(filename));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        super.store(new FileWriter(filename), "");
    }

    @Override
    public void setValue(String key, String value) {
        super.setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return super.getProperty(key);
    }
}
