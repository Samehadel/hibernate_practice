package com.hibernate.practice.author.entity;

import com.hibernate.practice.address.entity.Address;
import com.hibernate.practice.author.dto.AuthorDTO;
import com.hibernate.practice.books.entity.Book;
import com.hibernate.practice.models.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AUTHORS")
@Data
public class Author extends Auditable {

    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorSequenceGenerator")
    @SequenceGenerator(name = "authorSequenceGenerator", sequenceName = "authorSequence", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @CollectionTable(name = "BOOKS", joinColumns = @JoinColumn(name = "AUTHOR_ID"))
    @ElementCollection
    private Set<Book> books = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    public void addBook(Book book) {
        if(book != null) {
            books.add(book);
        }
    }

    public Author() {
    }

    public Author (AuthorDTO authorDTO) {
        this.name = authorDTO.getName();
        this.email = authorDTO.getEmail();
        this.address = new Address(authorDTO.getAddress());
    }
}
