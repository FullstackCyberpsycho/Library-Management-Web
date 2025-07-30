package com.example.LibraryManagementWeb.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Book {
    private int id;

    @NotBlank(message = "Название книги не должно быть пустым")
    private String name;

    @NotBlank(message = "ФИО автора не должно быть пустым")
    private String fullNameAuthor;

    @NotNull(message = "Год книги не должно быть пустым")
    @Min(value = 0, message = "Год книги не может быть отрицательным")
    private int year;

    public Book() {}

    public Book(String name, int year, String fullNameAuthor, int id) {
        this.name = name;
        this.year= year;
        this.fullNameAuthor = fullNameAuthor;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullNameAuthor() {
        return fullNameAuthor;
    }

    public void setFullNameAuthor(String fullNameAuthor) {
        this.fullNameAuthor = fullNameAuthor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
