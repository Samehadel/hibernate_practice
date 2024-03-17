package com.hibernate.practice.books.controllers;

import com.hibernate.practice.author.repository.AuthorRepository;
import com.hibernate.practice.books.dto.BookDTO;
import com.hibernate.practice.books.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private AuthorRepository authorRepository;


    @DeleteMapping("/{authorId}/{title}")
    public ResponseEntity<Boolean> deleteAuthor(@PathVariable("authorId") Long authorId, @PathVariable("title") String title) {
        authorRepository
                .findById(authorId)
                .ifPresent(author -> {
                    author.getBooks().removeIf(book -> book.getTitle().equals(title));
                    authorRepository.save(author);
                });
        return ResponseEntity.ok(true);
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> createBook(@RequestBody BookDTO book){
        Book newBook = new Book();
        newBook.setTitle(book.title);
        authorRepository.findById(book.authorId).ifPresent(author -> {
            author.addBook(newBook);
            authorRepository.save(author);
        });

        return ResponseEntity.ok(true);
    }
}
