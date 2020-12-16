package com.github.devkat.service;

import javax.persistence.EntityManagerFactory;

import org.jinq.jpa.JPAQueryLogger;
import org.jinq.jpa.JinqJPAStreamProvider;

public class AbstractPersistenceService {

    protected final JinqJPAStreamProvider streams;

    public AbstractPersistenceService(final EntityManagerFactory entityManagerFactory) {
        streams = new JinqJPAStreamProvider(entityManagerFactory);
        streams.setHint("queryLogger", (JPAQueryLogger) (query, positionParameters, namedParameters) ->
                System.out.println("  " + query));
    }

}
