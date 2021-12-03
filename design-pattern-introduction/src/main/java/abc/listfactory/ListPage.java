package abc.listfactory;

import abc.factory.Page;

public class ListPage extends Page {

    public ListPage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        var sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html><head><title>");
        sb.append(title);
        sb.append("</title></head>\n");
        sb.append("<body>\n");
        sb.append("<h1>\n");
        sb.append("<ul>\n");
        for (var item: content) {
            sb.append(item.makeHtml());
        }
        sb.append("</ul>\n");
        sb.append("<hr><address>\n");
        sb.append(author);
        sb.append("<address>\n");
        sb.append("</body></html>\n");
        return sb.toString();
    }
}
