/*package com.example.LibraryManagementWeb.services;


import com.example.LibraryManagementWeb.dao.BookDAO2;
import com.example.LibraryManagementWeb.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookServiceImplTest {
    @Mock
    private BookDAO2 bookDAO;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddBook() {
        Book book = new Book("Книга", 1234, "ФИО", 1);
        bookService.addBook(book);

        verify(bookDAO).addBook(book);
    }

    @Test
    void testGetAllBook() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Книга1", 2025, "ФИО1", 1));
        books.add(new Book("Книга2", 2025, "ФИО2", 2));

        when(bookDAO.getAllBook()).thenReturn(books);

        List<Book> res = bookService.getAllBook();

        assertAll(
                () -> assertEquals(2, res.size()),
                () -> assertEquals("Книга1", res.get(0).getName())
        );

    }

    @Test
    void testGetBook() {
        Book book = new Book("Книга", 2025, "ФИО", 1);
        when(bookDAO.getBook(1)).thenReturn(book);

        Book res = bookService.getBook(1);

        assertEquals("Книга", res.getName());
        verify(bookDAO).getBook(1);
    }

    @Test
    void testUpdateBook() {
        Book updated = new Book("Новое имя", 2025, "ФИО", 1);
        bookService.updateBook(1, updated);
        verify(bookDAO).updateBook(1, updated);
    }

    @Test
    void testDeleteBook() {
        bookService.deleteBook(5);
        verify(bookDAO).deleteBook(5);
    }
}
*/