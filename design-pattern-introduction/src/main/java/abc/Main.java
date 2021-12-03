package abc;

import abc.factory.Factory;

public class Main {

    public static void main(String[] args) {
        var factory = Factory.getFactory("abc.listfactory.ListFactory");

        var blog1 = factory.createLink("Blog 1", "https://example.com/blog1");
        var blog2 = factory.createLink("Blog 2", "https://example.com/blog2");
        var blog3 = factory.createLink("Blog 3", "https://example.com/blog3");

        var blogTray = factory.createTray("Blog Site");
        blogTray.add(blog1);
        blogTray.add(blog2);
        blogTray.add(blog3);

        var news1 = factory.createLink("News 1", "https://example.com/news1");
        var news2 = factory.createLink("News 1", "https://example.com/news2");
        var news3 = factory.createTray("News 3");
        news3.add(factory.createLink("News 3 (US)", "https://example.com/news3us"));
        news3.add(factory.createLink("News 3 (Japan)", "https://example.com/news3jp"));

        var newsTray = factory.createTray("News Site");
        newsTray.add(news1);
        newsTray.add(news2);
        newsTray.add(news3);

        var page = factory.createPage("Blog and News", "Hiroshi Yuki");
        page.add(blogTray);
        page.add(newsTray);

        System.out.println(page);
    }
}
