package com.github.devkat.persistence.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookToCharacterDto {

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
