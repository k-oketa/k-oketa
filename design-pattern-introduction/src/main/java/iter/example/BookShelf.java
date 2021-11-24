package iter.example;

public class BookShelf implements Iterable<Book> {

    private final Book[] books;
    private int last = 0;

    BookShelf(int maximum) {
        this.books = new Book[maximum];
    }

    void appendBook(Book book) {
        books[last] = book;
        last++;
    }

    int getLength() {
        return last;
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    @Override
    public BookShelfIterator iterator() {
        return new BookShelfIterator(this);
    }
}
