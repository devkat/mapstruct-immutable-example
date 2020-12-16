package com.github.devkat.service;

import javax.persistence.EntityManager;

import com.github.devkat.domain.Character;
import com.github.devkat.domain.*;
import com.github.devkat.persistence.dto.BookDto;
import com.github.devkat.persistence.dto.BookToCharacterDto;
import com.github.devkat.persistence.dto.CharacterDto;
import com.github.devkat.persistence.dto.WithIdDto;
import com.github.devkat.persistence.jinq.TupleOps;
import com.github.devkat.persistence.mapping.Mappers;
import fj.P2;
import fj.data.Stream;
import org.jinq.orm.stream.JinqStream;

public class BookService extends AbstractPersistenceService {

    public BookService(final EntityManager entityManager) {
        super(entityManager);
    }

    private JinqStream<BookDto> books(final EntityManager entityManager) {
        return streams.streamAll(entityManager, BookDto.class);
    }

    public Stream<P2<WithId<BookId, Book>, WithId<CharacterId, Character>>> getBooksWithCharacters() {
        return Stream
                .iterableStream(books(entityManager)
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

    public WithId<BookId, Book> createBook(final Book book) {
        return persist(Mappers.BookMapper.instance, book);
    }

    public WithId<CharacterId, Character> createCharacter(final Character ch) {
        return persist(Mappers.CharacterMapper.instance, ch);
    }

    public void addCharacterToBook(final BookId bookId, final CharacterId characterId) {
        entityManager.persist(Mappers.BookToCharacterMapper.instance.toDto(
                ImmutableBookToCharacter.of(bookId, characterId)
        ));
    }

}
