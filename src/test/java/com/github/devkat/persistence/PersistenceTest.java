package com.github.devkat.persistence;

import com.github.devkat.domain.Character;
import com.github.devkat.domain.*;
import com.github.devkat.service.BookService;
import fj.P2;
import fj.Unit;
import fj.data.List;
import fj.data.Stream;
import fj.function.Effect1;
import org.junit.jupiter.api.Test;

import static com.github.devkat.domain.Species.HUMAN;
import static fj.F2Functions.tuple;
import static fj.data.Option.none;
import static fj.data.Option.some;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersistenceTest extends AbstractPersistenceTest {

    private final BookService bookService;

    {
        bookService = new BookService(entityManager);
    }

    @Test
    public void testPersistence() {
        transactional(() -> {

            final WithId<BookId, Book> book = bookService.createBook(ImmutableBook.of("Night Watch"));

            final Effect1<Character> addCharacter = (ch) -> {
                final WithId<CharacterId, Character> chRead = bookService.createCharacter(ch);
                bookService.addCharacterToBook(book.getId(), chRead.getId());
            };

            final Character vimes = ImmutableCharacter.of("Samuel Vimes", some(HUMAN));
            final Character nobby = ImmutableCharacter.copyOf(vimes).withName("Nobby Nobbs").withSpecies(none());

            addCharacter.f(vimes);
            addCharacter.f(nobby);

            final Stream<P2<WithId<BookId, Book>, WithId<CharacterId, Character>>> booksWithCharacters =
                    bookService.getBooksWithCharacters();

            assertTrue(booksWithCharacters.isNotEmpty());

            booksWithCharacters.foreach(tuple((bk, ch) -> {
                System.out.printf("%s (%s)%n", ch.getData().getName(), ch.getData().getSpecies());
                return Unit.unit();
            }));

        });
    }

}
