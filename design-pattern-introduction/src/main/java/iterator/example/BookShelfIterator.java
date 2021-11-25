package iterator.example;

import java.util.Iterator;

public class BookShelfIterator implements Iterator<Book> {

    private final BookShelf books;
    private int index = 0;

    public BookShelfIterator(BookShelf bookShelf) {
        this.books = bookShelf;
    }

    @Override
    public boolean hasNext() {
        return index < books.getLength();
    }

    @Override
    public Book next() {
        var book = books.getBookAt(index);
        index++;
        return book;
    }
}
