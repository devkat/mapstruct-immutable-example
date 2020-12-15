package com.github.devkat.persistence.mapping;

import com.github.devkat.model.Book;
import com.github.devkat.model.BookToCharacter;
import com.github.devkat.model.Character;
import com.github.devkat.persistence.dto.BookDto;
import com.github.devkat.persistence.dto.BookToCharacterDto;
import com.github.devkat.persistence.dto.CharacterDto;
import org.mapstruct.Mapper;

public final class Mappers {

    @Mapper(uses = BookIdMapper.class)
    public interface BookMapper extends DtoMapper<Book, BookDto> {
        BookMapper instance = org.mapstruct.factory.Mappers.getMapper(BookMapper.class);
    }

    @Mapper(uses = CharacterIdMapper.class)
    public interface CharacterMapper extends DtoMapper<Character, CharacterDto> {
        CharacterMapper instance = org.mapstruct.factory.Mappers.getMapper(CharacterMapper.class);
    }

    @Mapper(uses = { BookIdMapper.class, CharacterIdMapper.class })
    public interface BookToCharacterMapper /*extends DtoMapper<BookToCharacter, BookToCharacterDto>*/ {
        BookToCharacterMapper instance = org.mapstruct.factory.Mappers.getMapper(BookToCharacterMapper.class);
        BookToCharacterDto toDto(final BookToCharacter entity);
    }

}
