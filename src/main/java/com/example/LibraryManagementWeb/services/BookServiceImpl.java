package com.example.LibraryManagementWeb.services;

import com.example.LibraryManagementWeb.dao.BookDAO;
import com.example.LibraryManagementWeb.models.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookDAO.getAllBook();
    }

    @Override
    public Book getBook(int id) {
        return bookDAO.getBook(id);
    }

    @Override
    public void updateBook(int id, Book updateBook) {
        bookDAO.updateBook(id, updateBook);
    }

    @Override
    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }

    @Override
    public void deleteAllBook() {
        bookDAO.deleteAllBook();
    }
}
