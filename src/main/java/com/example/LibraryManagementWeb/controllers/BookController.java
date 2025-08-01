/*package com.example.LibraryManagementWeb.controllers;

import com.example.LibraryManagementWeb.models.Book;
import com.example.LibraryManagementWeb.services.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public String mainMenu() {
        return "book/mainMenu";
    }

    @GetMapping("/list")
    public String getListBook(Model model) {
        model.addAttribute("books", bookService.getAllBook());
        return "book/list";
    }

    @GetMapping("/add")
    public String getAddBook(@ModelAttribute("book") Book book) {
        return "book/add";
    }

    @PostMapping()
    public String addBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/add";
        }
        bookService.addBook(book);
        return "redirect:/book";
    }

    @GetMapping("/{id}")
    public String getInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "book/info";
    }

    @GetMapping("/{id}/update")
    public String getUpdate(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBook(id));
        return "book/update";
    }

    @PatchMapping("/{id}/update")
    public String updateBook(@PathVariable("id") int id, @ModelAttribute("book") @Valid Book book,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/update";
        }
        bookService.updateBook(id, book);
        return "redirect:/book";
    }

    @DeleteMapping("/{id}/delete")
    public String getDeleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return "redirect:/book";
    }

    @GetMapping("/delete-all")
    public String getDeleteAll() {
        bookService.deleteAllBook();
        return "redirect:/book";
    }
}*/