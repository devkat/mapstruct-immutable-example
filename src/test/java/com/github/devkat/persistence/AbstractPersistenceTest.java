package com.github.devkat.persistence;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.spi.PersistenceUnitTransactionType;

import com.github.devkat.domain.WithId;
import com.github.devkat.persistence.dto.WithIdDto;
import com.github.devkat.persistence.mapping.DtoMapper;
import fj.function.Effect0;

import static javax.persistence.Persistence.createEntityManagerFactory;
import static org.eclipse.persistence.config.PersistenceUnitProperties.TRANSACTION_TYPE;

public abstract class AbstractPersistenceTest {

    protected final EntityManager entityManager;

    {
        final Map<String, String> properties = new HashMap<>();
        properties.put(TRANSACTION_TYPE, PersistenceUnitTransactionType.RESOURCE_LOCAL.name());
        final EntityManagerFactory entityManagerFactory =
                createEntityManagerFactory("JPATest", properties);
        entityManager = entityManagerFactory.createEntityManager();
    }

    protected void transactional(final Effect0 f) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            f.f();
            tx.commit();
        } catch (final RuntimeException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

}
