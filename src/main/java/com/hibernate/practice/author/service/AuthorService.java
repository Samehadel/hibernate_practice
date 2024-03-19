package com.hibernate.practice.author.service;

import com.hibernate.practice.author.dto.AuthorDTO;
import org.springframework.http.ResponseEntity;

public interface AuthorService {
    AuthorDTO findAuthor(Long id);
    void updateAuthorName(Long id, String authorName);
    void deleteAuthor(Long id);
    AuthorDTO findAuthorWithOptimisticForceLock(Long id);
    AuthorDTO findAuthorWithOptimisticLock(Long id);

    ResponseEntity<Long> createAuthor(AuthorDTO authorDTO);

    AuthorDTO findAuthorWithPessimisticWriteLock(Long id);
    AuthorDTO findAuthorWithPessimisticReadLock(Long id);
}
