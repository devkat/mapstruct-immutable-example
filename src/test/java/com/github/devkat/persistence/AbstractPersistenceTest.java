package com.github.devkat.persistence;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.spi.PersistenceUnitTransactionType;

import com.github.devkat.model.WithId;
import com.github.devkat.persistence.dto.WithIdDto;
import com.github.devkat.persistence.mapping.DtoMapper;
import fj.function.Effect0;
import org.jinq.jpa.JPAQueryLogger;
import org.jinq.jpa.JinqJPAStreamProvider;

import static javax.persistence.Persistence.createEntityManagerFactory;
import static org.eclipse.persistence.config.PersistenceUnitProperties.TRANSACTION_TYPE;

public abstract class AbstractPersistenceTest {

    protected final JinqJPAStreamProvider streams;
    protected final EntityManager entityManager;

    public AbstractPersistenceTest() {
        final Map<String, String> properties = new HashMap<>();
        properties.put(TRANSACTION_TYPE, PersistenceUnitTransactionType.RESOURCE_LOCAL.name());
        final EntityManagerFactory entityManagerFactory =
                createEntityManagerFactory("JPATest", properties);
        streams = new JinqJPAStreamProvider(entityManagerFactory);
        streams.setHint("queryLogger", (JPAQueryLogger) (query, positionParameters, namedParameters) ->
                System.out.println("  " + query));
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

    protected <ID, A, D extends WithIdDto<ID, A>> WithId<ID, A> persist(final DtoMapper<A, D> mapper, final A entity) {
        final D dto = mapper.toDto(entity);
        entityManager.persist(dto);
        entityManager.flush();
        return dto.toEntity();
    }
}
