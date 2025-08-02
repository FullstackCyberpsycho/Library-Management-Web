package com.example.LibraryManagementWeb.repository;

import com.example.LibraryManagementWeb.models.Book;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}