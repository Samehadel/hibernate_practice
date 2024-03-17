package com.hibernate.practice;

import com.hibernate.practice.author.entity.Author;
import com.hibernate.practice.author.repository.AuthorRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnitUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernatePracticeApplicationTests {
	/*@Autowired
	private AuthorRepository authorRepository;

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetReference() {
		Author reference = authorRepository.getReference(1L);
		PersistenceUnitUtil persistenceUnitUtil = emf.getPersistenceUnitUtil();
		boolean loaded = persistenceUnitUtil.isLoaded(reference);
		Assertions.assertFalse(loaded);

	}*/

}
