package com.github.devkat.persistence;

import com.github.devkat.domain.Character;
import com.github.devkat.domain.*;
import com.github.devkat.persistence.dto.BookDto;
import com.github.devkat.persistence.dto.BookToCharacterDto;
import com.github.devkat.persistence.dto.CharacterDto;
import com.github.devkat.persistence.mapping.Mappers;
import fj.data.List;
import fj.function.Effect1;
import org.jinq.orm.stream.JinqStream;
import org.jinq.tuples.Pair;
import org.junit.jupiter.api.Test;

import static com.github.devkat.domain.Species.HUMAN;
import static fj.data.Option.none;
import static fj.data.Option.some;
import static org.junit.jupiter.api.Assertions.*;

public class PersistenceTest extends AbstractPersistenceTest {

    private JinqStream<BookDto> books() {
        return streams.streamAll(entityManager, BookDto.class);
    }

    @Test
    public void testPersistence() {
        transactional(() -> {

            final WithId<BookId, Book> book = persist(Mappers.BookMapper.instance,
                    ImmutableBook.of("Night Watch"));

            final Effect1<Character> persistCharacter = (ch) -> {

                final WithId<CharacterId, Character> chRead = persist(Mappers.CharacterMapper.instance, ch);

                entityManager.persist(Mappers.BookToCharacterMapper.instance.toDto(ImmutableBookToCharacter.builder()
                        .bookId(book.getId())
                        .characterId(chRead.getId())
                        .build()));

            };

            final Character vimes = ImmutableCharacter.of("Samuel Vimes", some(HUMAN));
            final Character nobby = ImmutableCharacter.copyOf(vimes).withName("Nobby Nobbs").withSpecies(none());

            persistCharacter.f(vimes);
            persistCharacter.f(nobby);

            final List<Pair<Pair<BookDto, BookToCharacterDto>, CharacterDto>> bookRead = List.iterableList(books()
                            .leftOuterJoin(
                                    (b, source) -> source.stream(BookToCharacterDto.class),
                                    (b, r) -> b.getId() == r.getBookId()
                            )
                            .leftOuterJoin(
                                    (p, source) -> source.stream(CharacterDto.class),
                                    (p, c) -> p.getTwo().getCharacterId() == c.getId()
                            )
                            .toList());

            assertTrue(bookRead.isNotEmpty());

            bookRead.forEach(pair -> {
                final WithId<CharacterId, Character> ch = pair.getTwo().toEntity();
                assertNotNull(ch);
                System.out.printf("%s (%s)%n", ch.getData().getName(), ch.getData().getSpecies());
            });

        });
    }

}
