package iter.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookShelfIteratorTests {

    private BookShelfIterator bookShelfIterator;

    @BeforeEach
    void setUp() {
        var bookShelf = new BookShelf(2);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelfIterator = bookShelf.iterator();
    }

    @Test
    void testHasNext() {
        assertTrue(bookShelfIterator.hasNext());
    }

    @Test
    void testDoNotHasNext() {
        bookShelfIterator.next();
        bookShelfIterator.next();
        assertFalse(bookShelfIterator.hasNext());
    }
}
