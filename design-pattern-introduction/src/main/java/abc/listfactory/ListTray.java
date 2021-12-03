package abc.listfactory;

import abc.factory.Tray;

public class ListTray extends Tray {

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHtml() {
        var sb = new StringBuilder();
        sb.append("<ul>\n");
        sb.append(caption);
        sb.append("\n<ul>");
        for (var item: tray) {
            sb.append(item.makeHtml());
        }
        sb.append("<ul>\n");
        sb.append("<li>\n");
        return sb.toString();
    }
}
