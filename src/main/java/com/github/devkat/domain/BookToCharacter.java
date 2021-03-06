package com.github.devkat.domain;

import org.immutables.value.Value;

@Value.Immutable @Tuple
public interface BookToCharacter {

    BookId getBookId();

    CharacterId getCharacterId();

}
