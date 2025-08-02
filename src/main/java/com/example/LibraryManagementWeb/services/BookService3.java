package com.example.LibraryManagementWeb.services;

import com.example.LibraryManagementWeb.repository.BookRepository;
import com.example.LibraryManagementWeb.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService3 {
    private BookRepository bookRepository;

    public BookService3(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    public Book update(long id, Book updateBook) {
        return bookRepository.findById(id)
                .map(b -> {
                    b.setName(updateBook.getName());
                    b.setFullNameAuthor(updateBook.getFullNameAuthor());
                    b.setYear(updateBook.getYear());
                    return bookRepository.save(b);
                }).orElseThrow();
    }

    public boolean deleteById(long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
