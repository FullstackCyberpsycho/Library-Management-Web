package com.example.LibraryManagementWeb.services;

import com.example.LibraryManagementWeb.models.Book;
import com.example.LibraryManagementWeb.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookHtmlControllerTest  {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService3 bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddBook() {
        Book book = new Book(1, "Книга", "Автор", 1234);
        bookService.save(book);

        verify(bookRepository).save(book);
    }

    @Test
    void testGetAllBook() {
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
    void testGetBook() {
        Book book = new Book(1, "Книга", "Автор1", 1234);
        when(bookRepository.findById((long)1)).thenReturn(Optional.of(book));

        Optional<Book> res = bookService.findById((long) 1);

        assertEquals("Книга", res.get().getName());
        verify(bookRepository).findById((long)1);
    }
}