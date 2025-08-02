package com.example.LibraryManagementWeb.services;

import com.example.LibraryManagementWeb.models.Book;
import com.example.LibraryManagementWeb.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookService3Test {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService3 bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        Book book = new Book(1, "Книга", "Автор", 1234);

        bookService.save(book);

        verify(bookRepository).save(book);
    }

    @Test
    void testFindAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Книга1", "Автор1", 1234));
        books.add(new Book(2, "Книга2", "Автор2", 4321));

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> res = bookService.findAll();

        assertAll(
                () -> assertEquals(2, res.size()),
                () -> assertEquals("Книга1", res.get(0).getName())
        );
    }

    @Test
    void testFindById() {
        Book book = new Book(1, "Книга", "Автор", 1234);
        when(bookRepository.findById((long)1)).thenReturn(Optional.of(book));

        Optional<Book> res = bookService.findById(1);

        assertEquals("Книга", res.get().getName());
    }

    @Test
    void testDeleteById() {
        when(bookRepository.existsById((long)5)).thenReturn(true);

        boolean result = bookService.deleteById(5);

        assertTrue(result);
        verify(bookRepository).deleteById((long)5);
    }

    @Test
    void testDeleteUserSuccess() {
        when(bookRepository.existsById((long)1)).thenReturn(true);

        boolean result = bookService.deleteById(1);

        assertTrue(result);
        verify(bookRepository).deleteById((long)1);
    }
}
