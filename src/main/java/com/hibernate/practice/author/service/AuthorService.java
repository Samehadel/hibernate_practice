package com.hibernate.practice.author.service;

import com.hibernate.practice.author.dto.AuthorDTO;
import com.hibernate.practice.author.entity.Author;
import com.hibernate.practice.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public AuthorDTO findByEmail(String email) {
        AuthorDTO authorDTO = null;
        Author author = authorRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        if (author != null) {
            authorDTO = new AuthorDTO(author);
        }
        return authorDTO;
    }

    @Transactional(rollbackFor = Throwable.class)
    public AuthorDTO findAuthor(Long id) {
        AuthorDTO authorDTO = null;
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            authorDTO = new AuthorDTO(author);
        }
        authorRepository.save(author);
        return authorDTO;

    }

    @Transactional(rollbackFor = Throwable.class)
    public void updateAuthorName(Long id, String authorName) {
        authorRepository.findById(id).ifPresent(author -> {
            author.setName(authorName);
        });
    }


    public void deleteAuthor(Long id) {
        authorRepository.findById(id).ifPresent(author -> {
            authorRepository.delete(author);
        });
        //jpaAuthorRepository.deleteById(id);
    }

    @Transactional(rollbackFor = Throwable.class)
    public AuthorDTO findAuthorWithOptimisticForceLock(Long id) {
        AuthorDTO authorDTO = null;
        Author author = authorRepository.findByIdWithOptimisticForceLock(id);
        if (author != null) {
            authorDTO = new AuthorDTO(author);
        }
        return authorDTO;
    }

    @Transactional
    public AuthorDTO findAuthorWithOptimisticLock(Long id) {
        AuthorDTO authorDTO = null;
        Author author = authorRepository.findByIdWithOptimisticLock(id);
        if (author != null) {
            authorDTO = new AuthorDTO(author);
        }
        return authorDTO;
    }


    public ResponseEntity<Long> createAuthor(AuthorDTO authorDTO) {
        try {
            Author author = new Author(authorDTO);
            author = authorRepository.save(author);
            return ResponseEntity.ok(author.getId());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Transactional
    public AuthorDTO findAuthorWithPessimisticWriteLock(Long id) {
        AuthorDTO authorDTO = null;
        Author author = authorRepository.findByIdWithPessimisticWriteLock(id);
        if (author != null) {
            authorDTO = new AuthorDTO(author);
        }
        return authorDTO;
    }

    @Transactional
    public AuthorDTO findAuthorWithPessimisticReadLock(Long id) {
        AuthorDTO authorDTO = null;
        Author author = authorRepository.findByIdWithPessimisticReadLock(id);
        if (author != null) {
            authorDTO = new AuthorDTO(author);
        }
        return authorDTO;
    }
}
