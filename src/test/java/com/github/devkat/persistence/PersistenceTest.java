package com.github.devkat.persistence;

import com.github.devkat.domain.Character;
import com.github.devkat.domain.*;
import com.github.devkat.persistence.dto.BookDto;
import com.github.devkat.persistence.dto.BookToCharacterDto;
import com.github.devkat.persistence.dto.CharacterDto;
import com.github.devkat.persistence.mapping.Mappers;
import com.github.devkat.service.BookService;
import fj.F0;
import fj.P2;
import fj.Unit;
import fj.data.List;
import fj.function.Effect1;
import org.jinq.orm.stream.JinqStream;
import org.jinq.tuples.Pair;
import org.junit.jupiter.api.Test;

import static com.github.devkat.domain.Species.HUMAN;
import static fj.F2Functions.tuple;
import static fj.data.Option.none;
import static fj.data.Option.some;
import static org.junit.jupiter.api.Assertions.*;

public class PersistenceTest extends AbstractPersistenceTest {

    private final BookService bookService;

    {
        bookService = new BookService(entityManagerFactory);
    }

    @Test
    public void testPersistence() {
        transactional(() -> {

            final WithId<BookId, Book> book = persist(Mappers.BookMapper.instance,
                    ImmutableBook.of("Night Watch"));

            final Effect1<Character> persistCharacter = (ch) -> {

                final WithId<CharacterId, Character> chRead = persist(Mappers.CharacterMapper.instance, ch);

                entityManager.persist(Mappers.BookToCharacterMapper.instance.toDto(
                        ImmutableBookToCharacter.of(book.getId(), chRead.getId())
                ));

            };

            final Character vimes = ImmutableCharacter.of("Samuel Vimes", some(HUMAN));
            final Character nobby = ImmutableCharacter.copyOf(vimes).withName("Nobby Nobbs").withSpecies(none());

            persistCharacter.f(vimes);
            persistCharacter.f(nobby);

            final List<P2<WithId<BookId, Book>, WithId<CharacterId, Character>>> booksWithCharacters =
                    bookService.getBooksWithCharacters(entityManager);

            assertTrue(booksWithCharacters.isNotEmpty());

            booksWithCharacters.foreach(tuple((bk, ch) -> {
                System.out.printf("%s (%s)%n", ch.getData().getName(), ch.getData().getSpecies());
                return Unit.unit();
            }));

        });
    }

}
