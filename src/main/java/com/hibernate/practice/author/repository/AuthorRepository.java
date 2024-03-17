package com.hibernate.practice.author.repository;

import com.hibernate.practice.author.entity.Author;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Query("SELECT A FROM Author A WHERE A.id = :id")
    Author findByIdWithOptimisticForceLock(@Param("id") Long id);

    @Lock(LockModeType.OPTIMISTIC)
    @Query("SELECT A FROM Author A WHERE A.id = :id")
    Author findByIdWithOptimisticLock(@Param("id") Long id);
}
