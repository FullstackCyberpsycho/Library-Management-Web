package com.example.LibraryManagementWeb.controllers;

import com.example.LibraryManagementWeb.models.Book;
import com.example.LibraryManagementWeb.services.BookService3;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<Optional<Book>> getInfo(@PathVariable long id) {
        if (bookService.findById(id) != null) {
            return ResponseEntity.ok(bookService.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/update")
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody @Valid Book book) {
        if (bookService.update(id, book) != null) {
            return ResponseEntity.ok(bookService.update(id, book));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> getDeleteBook(@PathVariable("id") long id) {
        if (bookService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> getDeleteAll() {
        if (bookService.deleteAll()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}