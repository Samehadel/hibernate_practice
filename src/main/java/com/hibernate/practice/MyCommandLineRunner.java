package com.hibernate.practice;

import com.hibernate.practice.address.entity.Address;
import com.hibernate.practice.author.entity.Author;
import com.hibernate.practice.author.repository.AuthorRepository;
import com.hibernate.practice.books.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Executing code after application startup...");
        Author author = createAuthor();
        Book firstBook = createBook("FirstBook");
        Book secondBook = createBook("SecondBook");
        Address address = createAddress();
        author.addBook(firstBook);
        author.addBook(secondBook);
        author.setAddress(address);
        authorRepository.save(author);
    }

    private Author createAuthor() {
        Author author = new Author();
        author.setName("AuthorName");
        author.setEmail("authorEmail@example.com");
        return author;
    }

    private Book createBook(String title) {
        Book book = new Book();
        book.setTitle(title);
        return book;
    }

    private Address createAddress() {
        Address address = new Address();
        address.setCity("City_1");
        address.setStreet("Street_1");
        return address;
    }
}