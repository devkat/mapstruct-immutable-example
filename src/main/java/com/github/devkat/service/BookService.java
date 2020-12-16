package com.github.devkat.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.github.devkat.domain.Book;
import com.github.devkat.domain.BookId;
import com.github.devkat.domain.Character;
import com.github.devkat.domain.CharacterId;
import com.github.devkat.domain.WithId;
import com.github.devkat.persistence.dto.BookDto;
import com.github.devkat.persistence.dto.BookToCharacterDto;
import com.github.devkat.persistence.dto.CharacterDto;
import fj.P2;
import fj.data.List;
import org.jinq.orm.stream.JinqStream;

import static fj.P.p;

public class BookService extends AbstractPersistenceService {

    public BookService(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    private JinqStream<BookDto> books(final EntityManager entityManager) {
        return streams.streamAll(entityManager, BookDto.class);
    }

    public List<P2<WithId<BookId, Book>, WithId<CharacterId, Character>>> getBooksWithCharacters(
            final EntityManager entityManager
    ) {
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
                .map(pair -> p(pair.getOne().getOne().toEntity(), pair.getTwo().toEntity()));

    }

}
