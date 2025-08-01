package com.example.LibraryManagementWeb.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
//@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Название книги не должно быть пустым")
    private String name;

    @NotBlank(message = "ФИО автора не должно быть пустым")
    private String fullNameAuthor;

    @NotNull(message = "Год книги не должно быть пустым")
    @Min(value = 0, message = "Год книги не может быть отрицательным")
    private int year;
}
