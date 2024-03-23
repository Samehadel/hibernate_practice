package com.hibernate.practice.author.dto;

import com.hibernate.practice.address.dto.AddressDTO;
import com.hibernate.practice.author.entity.Author;
import lombok.Data;

import java.io.Serializable;

@Data
public class AuthorDTO implements Serializable {
    private String name;
    private AddressDTO address;
    private String email;

    public AuthorDTO() {
    }

    public AuthorDTO (Author author) {
        this.name = author.getName();
        this.address = new AddressDTO(author.getAddress());
        this.email = author.getEmail();
    }
}
