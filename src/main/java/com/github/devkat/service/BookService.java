package com.github.devkat.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.github.devkat.domain.Character;
import com.github.devkat.domain.*;
import com.github.devkat.persistence.dto.BookDto;
import com.github.devkat.persistence.dto.BookToCharacterDto;
import com.github.devkat.persistence.dto.CharacterDto;
import com.github.devkat.persistence.dto.WithIdDto;
import com.github.devkat.persistence.jinq.TupleOps;
import fj.P2;
import fj.data.List;
import org.jinq.orm.stream.JinqStream;

public class BookService extends AbstractPersistenceService {

    public BookService(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    private JinqStream<BookDto> books(final EntityManager entityManager) {
        return streams.streamAll(entityManager, BookDto.class);
    }

    public List<P2<
                WithId<BookId, Book>,
                WithId<CharacterId, Character>
            >> getBooksWithCharacters(final EntityManager entityManager) {
        return List
                .iterableList(books(entityManager)
                .leftOuterJoin(
                        (b, source) -> source.stream(BookToCharacterDto.class),
                        (b, r) -> b.getId() == r.getBookId()
                )
                .leftOuterJoin(
                        (p, source) -> source.stream(CharacterDto.class),
                        (p, c) -> p.getTwo().getCharacterId() == c.getId()
                )
                .toList())
                .map(TupleOps::p2)
                .map(p -> p
                        .map1(TupleOps::p2)
                        .map1(P2::_1)
                        .map1(WithIdDto::toEntity)
                        .map2(WithIdDto::toEntity));
    }

}
