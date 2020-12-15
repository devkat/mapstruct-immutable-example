package com.github.devkat.persistence;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.spi.PersistenceUnitTransactionType;

import com.github.devkat.model.Book;
import com.github.devkat.model.ImmutableBook;
import com.github.devkat.persistence.dto.BookDto;
import com.github.devkat.persistence.mapping.Mappers;
import fj.function.Effect0;
import org.jinq.jpa.JPAQueryLogger;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.jinq.orm.stream.JinqStream;
import org.junit.jupiter.api.Test;

import static javax.persistence.Persistence.createEntityManagerFactory;
import static org.eclipse.persistence.config.PersistenceUnitProperties.TRANSACTION_TYPE;

public class PersistenceTest {

    private final JinqJPAStreamProvider streams;
    private final EntityManager entityManager;

    public PersistenceTest() {
        final Map<String, String> properties = new HashMap<>();

        properties.put(TRANSACTION_TYPE, PersistenceUnitTransactionType.RESOURCE_LOCAL.name());

        final EntityManagerFactory entityManagerFactory =
                createEntityManagerFactory("JPATest", properties);
        streams = new JinqJPAStreamProvider(entityManagerFactory);
        streams.setHint("queryLogger", (JPAQueryLogger) (query, positionParameters, namedParameters) ->
                System.out.println("  " + query));
        entityManager = entityManagerFactory.createEntityManager();
    }

    private JinqStream<BookDto> books() {
        return streams.streamAll(entityManager, BookDto.class);
    }

    private void transactional(final Effect0 f) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            f.f();
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) tx.rollback();
            throw e; // or display error message
        } finally {
            entityManager.close();
        }
    }

    @Test
    public void testPersistence() {
        transactional(() -> {

            final Book book = ImmutableBook.builder()
                    .title("Night Watch")
                    .build();

            entityManager.persist(Mappers.BookMapper.instance.toDto(book));

        });
    }

}
