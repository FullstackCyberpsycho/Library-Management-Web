/*package com.example.LibraryManagementWeb.services;

import com.example.LibraryManagementWeb.dao.BookDAO;
import com.example.LibraryManagementWeb.models.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl {
    private BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public List<Book> getAllBook() {
        return bookDAO.getAllBook();
    }

    public Book getBook(int id) {
        return bookDAO.getBook(id);
    }

    public void updateBook(int id, Book updateBook) {
        bookDAO.updateBook(id, updateBook);
    }

    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }

    public void deleteAllBook() {
        bookDAO.deleteAllBook();
    }
}*/