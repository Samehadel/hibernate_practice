package com.hibernate.practice.books.dto;

import com.hibernate.practice.books.entity.Book;

public class BookDTO {
    public Long id;
    public Long authorId;
    public String title;

    public BookDTO(Long authorId, Book book) {
        this.authorId = authorId;
        this.id = book.getId();
        this.title = book.getTitle();
    }
}
