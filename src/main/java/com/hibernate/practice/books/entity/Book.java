package com.hibernate.practice.books.entity;

import com.hibernate.practice.models.Auditable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Embeddable
@Data
public class Book {
    @Column(name = "TITLE")
    private String title;


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}
