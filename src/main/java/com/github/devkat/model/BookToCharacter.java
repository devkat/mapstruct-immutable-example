package com.github.devkat.model;

import org.immutables.value.Value;

@Value.Immutable
public interface BookToCharacter {

    BookId getBookId();

    CharacterId getCharacterId();

}