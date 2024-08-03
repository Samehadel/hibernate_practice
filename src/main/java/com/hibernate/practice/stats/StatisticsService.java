package com.hibernate.practice.stats;

import jakarta.persistence.EntityManagerFactory;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class StatisticsService {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public StatisticsService(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public Statistics getStatistics() {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        return sessionFactory.getStatistics();
    }

    public void logStatistics() {
        Statistics stats = getStatistics();
        log.info("Query cache hit count: " + stats.getQueryCacheHitCount());
        log.info("Query cache miss count: " + stats.getQueryCacheMissCount());

        log.info("Second level cache hit count: " + stats.getSecondLevelCacheHitCount());
        log.info("Second level cache miss count: " + stats.getSecondLevelCacheMissCount());
        log.info("Second level cache put count: " + stats.getSecondLevelCachePutCount());

        log.info("Entity load count: " + stats.getEntityLoadCount());
        log.info("Entity fetch count: " + stats.getEntityFetchCount());

        log.info("Collection load count: " + stats.getCollectionLoadCount());
        log.info("Collection fetch count: " + stats.getCollectionFetchCount());

    }
}