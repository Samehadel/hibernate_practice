package com.hibernate.practice.author.service;

import com.hibernate.practice.author.dto.AuthorDTO;
import com.hibernate.practice.author.entity.Author;
import com.hibernate.practice.author.repository.AuthorRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    @Autowired
    private EntityManagerFactory emf;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Transactional(rollbackFor = Throwable.class)
    @Override
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
    @Override
    public void updateAuthorName(Long id, String authorName) {
        authorRepository.findById(id).ifPresent(author -> {
            author.setName(authorName);
        });
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.findById(id).ifPresent(author -> {
            authorRepository.delete(author);
        });
        //jpaAuthorRepository.deleteById(id);
    }
}
