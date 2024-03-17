package com.hibernate.practice.author.service;

import com.hibernate.practice.author.dto.AuthorDTO;

public interface AuthorService {
    AuthorDTO findAuthor(Long id);
    void updateAuthorName(Long id, String authorName);
    void deleteAuthor(Long id);
}
