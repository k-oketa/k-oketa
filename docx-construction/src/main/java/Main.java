import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        try (var out = new FileOutputStream(new File("sample.docx"))) {
            var document = new XWPFDocument();
            document.write(out);
        }
    }
}
