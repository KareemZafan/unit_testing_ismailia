package tests;

import org.iti.mobile.Book;
import org.iti.mobile.Library;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {


    @Test
    void testAddBooks(){
        Library library= new Library();
        Book myBook = new Book("Tdd By Examples","Kent Beck",  "13$");
        library.addBooks(List.of(myBook, new Book("C Programming", "Denis Ritchie", "20$")));
        assertTrue(library.getBooksCount() == 0 );
        assertTrue(library.getCurrentBooks().contains(myBook));
    }

}
