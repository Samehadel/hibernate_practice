package com.hibernate.practice.author.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
/*
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource dataSource) {
        Map<String, String> properties = new HashMap<>();
        properties.put("spring.datasource.url", "jdbc:h2:mem:testdb");
        properties.put("spring.datasource.driverClassName", "org.h2.Driver");
        properties.put("spring.datasource.username", "sa");
        properties.put("spring.datasource.password", "password");
        properties.put("spring.jpa.database-platform", "org.hibernate.dialect.H2Dialect");
        properties.put("spring.h2.console.enabled", "true");
        properties.put("spring.jpa.show-sql", "true");
        properties.put("spring.jpa.properties.hibernate.format_sql", "true");
        properties.put("spring.jpa.hibernate.ddl-auto", "create");
        return builder
                .dataSource(dataSource)
                .packages("com.hibernate.practice")
                .properties(properties)
                .persistenceUnit("default")
                .build();
    }
*/
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
