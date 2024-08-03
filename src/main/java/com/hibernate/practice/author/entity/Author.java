package com.hibernate.practice.author.entity;

import com.hibernate.practice.address.entity.Address;
import com.hibernate.practice.author.dto.AuthorDTO;
import com.hibernate.practice.books.entity.Book;
import com.hibernate.practice.models.Auditable;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import java.util.ArrayList;
import java.util.List;

@Cacheable
@org.hibernate.annotations.Cache(
        usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE,
        region = "com.hibernate.practice.author.entity.Author"
)
@NaturalIdCache
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

    @org.hibernate.annotations.Cache(
            usage = CacheConcurrencyStrategy.READ_ONLY,
            region = "com.hibernate.practice.books.entity.Book"
    )
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    private List<Book> books;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @Column(name = "EMAIL", unique = true, nullable = false)
    @NaturalId
    private String email;

    public void addBook(Book book) {
        if (this.books == null) {
            this.books = new ArrayList<>();
        }

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
