package com.radius.library_service.vo;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Book details")
public class Book {
    @Schema(description = "Book ID", example = "123")
    private Long id;

    @Schema(description = "Book title", example = "Atomic Habbits")
    private String title;

    @Schema(description = "Author name", example = "James Clear")
    private String author;

    @Schema(description = "ISBN number", example = "978-0134685991")
    private String isbn;

    @Schema(description = "Book Publish Date", example = "2008-08-01")
    private LocalDate publishedDate;

    public Book(){
    }

    public Book(Long id, String title, String author, String isbn, LocalDate publishedDate) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }
}
