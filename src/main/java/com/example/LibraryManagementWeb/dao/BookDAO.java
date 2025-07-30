package com.example.LibraryManagementWeb.dao;

import com.example.LibraryManagementWeb.models.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.List;

@Component
@Repository
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBook(Book book) {
        jdbcTemplate.update( "INSERT INTO books(name, fullNameAuthor, year) VALUES(?, ?, ?)",
                book.getName(), book.getFullNameAuthor(), book.getYear());
    }

    public List<Book> getAllBook() {
        return jdbcTemplate.query("SELECT * FROM books",
                new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getBook(int id) {
        return jdbcTemplate.query("SELECT * FROM books WHERE id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void updateBook(int id, Book updateBook) {
        jdbcTemplate.update("UPDATE books SET name=?, fullNameAuthor=?, year=? WHERE id=?", updateBook.getName(),
                updateBook.getFullNameAuthor(), updateBook.getYear(), id);
    }

    public void deleteBook(int id) {
        jdbcTemplate.update("DELETE FROM books WHERE id=?", id);
    }

    public void deleteAllBook() {
        jdbcTemplate.update("DELETE FROM books");
    }
}
