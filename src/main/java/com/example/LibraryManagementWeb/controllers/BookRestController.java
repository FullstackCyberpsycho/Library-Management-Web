/*package com.example.LibraryManagementWeb.controllers;

import com.example.LibraryManagementWeb.models.Book;
import com.example.LibraryManagementWeb.services.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {
    private BookServiceImpl bookService;

    public BookRestController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public List<Book> getListBook() {
        return bookService.getAllBook();
    }

    @PostMapping()
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getInfo(@PathVariable int id) {
        if (bookService.getBook(id) != null) {
            return ResponseEntity.ok(bookService.getBook(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/update")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody @Valid Book book) {
        if (bookService.updateBook(id, book) != null) {
            return ResponseEntity.ok(bookService.updateBook(id, book));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> getDeleteBook(@PathVariable("id") int id) {
        if (bookService.deleteBook(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //@GetMapping("/delete-all")
    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> getDeleteAll() {
        if (bookService.deleteAllBook()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}*/