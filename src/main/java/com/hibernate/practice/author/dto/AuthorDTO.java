package com.hibernate.practice.author.dto;

import com.hibernate.practice.address.dto.AddressDTO;
import com.hibernate.practice.author.entity.Author;
import com.hibernate.practice.books.dto.BookDTO;
import com.hibernate.practice.books.entity.Book;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorDTO implements Serializable {
    private String name;
    private AddressDTO address;
    private String email;
    private List<BookDTO> books;

    public AuthorDTO() {
    }

    public AuthorDTO (Author author) {
        this.name = author.getName();
        this.address = new AddressDTO(author.getAddress());
        this.email = author.getEmail();

        if (this.books == null) {
            this.books = new ArrayList<>();
        }

        for (Book book : author.getBooks()) {
            this.books.add(new BookDTO(author.getId(), book));
        }
    }
}
