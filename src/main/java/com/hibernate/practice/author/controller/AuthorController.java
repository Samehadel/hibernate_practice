package com.hibernate.practice.author.controller;

import com.hibernate.practice.author.dto.AuthorDTO;
import com.hibernate.practice.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<AuthorDTO> findAuthor(@PathVariable("id") Long id) {
        AuthorDTO author = authorService.findAuthorWithOptimisticLock(id);
        return ResponseEntity.accepted().body(author);
    }

    @GetMapping("/find/with-optimistic-lock/{id}")
    public ResponseEntity<AuthorDTO> findAuthorWithOptimisticLock(@PathVariable("id") Long id) {
        AuthorDTO author = authorService.findAuthorWithOptimisticLock(id);
        return ResponseEntity.accepted().body(author);
    }

    @GetMapping("/find/with-optimistic-force-lock/{id}")
    public ResponseEntity<AuthorDTO> findAuthorWithOptimisticForceLock(@PathVariable("id") Long id) {
        AuthorDTO author = authorService.findAuthorWithOptimisticForceLock(id);
        return ResponseEntity.accepted().body(author);
    }

    @GetMapping("/find/with-pessimistic-write-lock/{id}")
    public ResponseEntity<AuthorDTO> findAuthorWithPessimisticWriteLock(@PathVariable("id") Long id) {
        AuthorDTO author = authorService.findAuthorWithPessimisticWriteLock(id);
        return ResponseEntity.accepted().body(author);
    }

    @GetMapping("/find/with-pessimistic-read-lock/{id}")
    public ResponseEntity<AuthorDTO> findAuthorWithPessimisticReadLock(@PathVariable("id") Long id) {
        AuthorDTO author = authorService.findAuthorWithPessimisticReadLock(id);
        return ResponseEntity.accepted().body(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.of(Optional.of(true));
    }

    @PutMapping("/update/{id}/{authorName}")
    public ResponseEntity<Boolean> updateAuthorName(@PathVariable("id") Long id, @PathVariable("authorName") String authorName) {
        authorService.updateAuthorName(id, authorName);
        return ResponseEntity.of(Optional.of(true));
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.createAuthor(authorDTO);
    }
}
