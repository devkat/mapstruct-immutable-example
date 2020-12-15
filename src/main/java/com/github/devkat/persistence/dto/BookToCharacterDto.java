package com.github.devkat.persistence.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(BookToCharacterDto.BookToCharacterId.class)
public class BookToCharacterDto {

    public static class BookToCharacterId implements Serializable {

        private final int bookId;
        private final int characterId;

        public BookToCharacterId(final int bookId, final int characterId) {
            this.bookId = bookId;
            this.characterId = characterId;
        }

        public int getBookId() {
            return bookId;
        }

        public int getCharacterId() {
            return characterId;
        }
    }

    @Id
    private int bookId;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(final int bookId) {
        this.bookId = bookId;
    }

    @Id
    private int characterId;

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(final int characterId) {
        this.characterId = characterId;
    }
}
