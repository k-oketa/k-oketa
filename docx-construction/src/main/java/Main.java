import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        try (var out = new FileOutputStream("sample.docx")) {
            var document = new XWPFDocument();
            var cid = BigInteger.ZERO;

            var paragraph = document.createParagraph();
            paragraph.createRun().setText("日本人は米を食べるのが");
            paragraph.getCTP().addNewCommentRangeStart().setId(cid);
            paragraph.createRun().setText("当たり前");
            paragraph.getCTP().addNewR().addNewCommentReference().setId(cid);
            var comments = document.createComments();
            var comment = comments.createComment(cid);
            comment.getCtComment().addNewP().addNewR().addNewT().setStringValue("話しことば例文：人間は当たり前のように罪を犯す。");
            comment.getCtComment().addNewP().addNewR().addNewT().setStringValue("修正例：人間は当然のように罪を犯す。");
            comment.getCtComment().addNewP().addNewR().addNewT().setStringValue("コメント：当然とするべき");
            paragraph.getCTP().addNewCommentRangeEnd().setId(cid);
            paragraph.createRun().setText("である。");
            document.write(out);
            System.out.println(document.getDocument());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
