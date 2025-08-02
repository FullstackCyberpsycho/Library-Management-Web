package com.example.LibraryManagementWeb.controllers;

import com.example.LibraryManagementWeb.models.Book;
import com.example.LibraryManagementWeb.services.BookService3;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookRestController2 {
    private BookService3 bookService;

    public BookRestController2(BookService3 bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public List<Book> getListBook() {
        return bookService.findAll();
    }

    @PostMapping()
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        return bookService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/update")
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody @Valid Book book) {
        try {
            Book updated = bookService.update(id, book);
            return ResponseEntity.ok(updated);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") long id) {
        if (bookService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> deleteAll() {
        bookService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}