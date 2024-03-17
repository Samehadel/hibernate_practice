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

    @Autowired
    private AuthorService authorService;


    @GetMapping("/find/{id}")
    public ResponseEntity<AuthorDTO> findAuthor(@PathVariable("id") Long id) {
        AuthorDTO author = authorService.findAuthor(id);
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
}
