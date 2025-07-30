package com.example.LibraryManagementWeb.dao;

import com.example.LibraryManagementWeb.models.Book;
import org.junit.jupiter.api.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookDAOTest {

    @Container
    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass");

    private BookDAO bookDAO;

    @BeforeAll
    void setUpDatabase() {
        DataSource dataSource = new DriverManagerDataSource(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword()
        );
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.execute("""
                CREATE TABLE books (
                    id SERIAL PRIMARY KEY,
                    name TEXT NOT NULL,
                    fullNameAuthor TEXT NOT NULL,
                    year INT NOT NULL
                );
            """);

        bookDAO = new BookDAO(jdbcTemplate);
    }

    @BeforeEach
    void clearTable() {
        bookDAO.deleteAllBook();
    }

    @Test
    void testAddBook() {
        Book book = new Book("Book", 2020, "ФИО", 1);
        bookDAO.addBook(book);

        List<Book> books = bookDAO.getAllBook();
        assertEquals(1, books.size());
        assertEquals("Book", books.get(0).getName());
    }

    @Test
    void testGetBook() {
        Book book = new Book("Book", 2025, "ФИО", 1);
        bookDAO.addBook(book);
        Book found = bookDAO.getAllBook().get(0);

        Book res = bookDAO.getBook(found.getId());
        assertNotNull(res);
        assertEquals("Book", res.getName());
    }

    @Test
    void testUpdateBook() {
        Book book = new Book("Book", 2025, "ФИО", 1);
        bookDAO.addBook(book);
        Book added = bookDAO.getAllBook().get(0);

        Book updated = new Book("New book", 2025, "ФИО2", 1);
        bookDAO.updateBook(added.getId(), updated);

        Book result = bookDAO.getBook(added.getId());
        assertEquals("New book", result.getName());
        assertEquals("ФИО2", result.getFullNameAuthor());
    }

    @Test
    void testDeleteBook() {
        bookDAO.addBook(new Book("Book", 2025, "ФИО", 1));
        Book added = bookDAO.getAllBook().get(0);
        bookDAO.deleteBook(added.getId());

        List<Book> books = bookDAO.getAllBook();
        assertTrue(books.isEmpty());
    }
}
