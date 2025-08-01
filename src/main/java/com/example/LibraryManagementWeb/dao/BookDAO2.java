/*package com.example.LibraryManagementWeb.dao;

import com.example.LibraryManagementWeb.models.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public class BookDAO2 {
    private final JdbcTemplate jdbcTemplate;

    public BookDAO2(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Book addBook(Book book) {
        jdbcTemplate.update( "INSERT INTO books(name, fullNameAuthor, year) VALUES(?, ?, ?)",
                book.getName(), book.getFullNameAuthor(), book.getYear());
        return book;
    }

    public List<Book> getAllBook() {
        return jdbcTemplate.query("SELECT * FROM books",
                new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getBook(int id) {
        return jdbcTemplate.query("SELECT * FROM books WHERE id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public Book updateBook(int id, Book updateBook) {
        jdbcTemplate.update("UPDATE books SET name=?, fullNameAuthor=?, year=? WHERE id=?", updateBook.getName(),
                updateBook.getFullNameAuthor(), updateBook.getYear(), id);
        return updateBook;
    }

    public boolean deleteBook(int id) {
        int res = jdbcTemplate.update("DELETE FROM books WHERE id=?", id);
        return res > 0;
    }

    public boolean deleteAllBook() {
        int res = jdbcTemplate.update("DELETE FROM books");
        return res > 0;
    }
}*/