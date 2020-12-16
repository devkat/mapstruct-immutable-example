package com.github.devkat.service;

import javax.persistence.EntityManager;

import com.github.devkat.domain.WithId;
import com.github.devkat.persistence.dto.WithIdDto;
import com.github.devkat.persistence.mapping.DtoMapper;
import org.jinq.jpa.JPAQueryLogger;
import org.jinq.jpa.JinqJPAStreamProvider;

public class AbstractPersistenceService {

    protected final EntityManager entityManager;
    protected final JinqJPAStreamProvider streams;

    public AbstractPersistenceService(final EntityManager entityManager) {
        this.entityManager = entityManager;
        streams = new JinqJPAStreamProvider(entityManager.getEntityManagerFactory());
        streams.setHint("queryLogger", (JPAQueryLogger) (query, positionParameters, namedParameters) ->
                System.out.println("  " + query));
    }

    protected <ID, A, D extends WithIdDto<ID, A>> WithId<ID, A> persist(final DtoMapper<A, D> mapper, final A entity) {
        final D dto = mapper.toDto(entity);
        entityManager.persist(dto);
        entityManager.flush();
        return dto.toEntity();
    }

}
