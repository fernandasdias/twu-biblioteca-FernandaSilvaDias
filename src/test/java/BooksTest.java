import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BooksTest {

    List<Books> booksList = new ArrayList<>();
    Books book1;

    @Before
    public void initializeBooks() {
        book1 = new Books("Book one", "Author one", 2011, 1);
        Books book2 = new Books("Book two", "Author two", 2019, 2);
        Books book3 = new Books("Book three", "Author three", 2001, 3);

        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book3);
    }

    @Test
    public void listOfBooksTest() {
        assertTrue(Books.listAllBooks(booksList));
    }

    @Test
    public void bookExistInLibraryTest() {
        assertTrue(Books.verifyBookIDFromLibrary(1,1));
    }

    @Test
    public void bookDoesntExistInLibraryTest() {
        assertTrue(Books.verifyBookIDFromLibrary(-1,1));
    }
//vou criar o checkoutstatus no construtor ou limitado apenas se o livro for checautado via menu? default false
    @Test
    public void checkoutBookTrue() {
        assertTrue(Books.checkoutBook(book1));
    }

    @Test
    public void returnBookTrue() {
        assertTrue(Books.returnBooks(book1));
    }
}