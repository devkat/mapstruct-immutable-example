package com.github.devkat.persistence.mapping;

import com.github.devkat.domain.Book;
import com.github.devkat.domain.BookToCharacter;
import com.github.devkat.domain.Character;
import com.github.devkat.persistence.dto.BookDto;
import com.github.devkat.persistence.dto.BookToCharacterDto;
import com.github.devkat.persistence.dto.CharacterDto;
import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

public final class Mappers {

    @Mapper(uses = BookIdMapper.class)
    public interface BookMapper extends DtoMapper<Book, BookDto> {
        BookMapper instance = getMapper(BookMapper.class);
    }

    @Mapper(uses = CharacterIdMapper.class)
    public interface CharacterMapper extends DtoMapper<Character, CharacterDto> {
        CharacterMapper instance = getMapper(CharacterMapper.class);
    }

    @Mapper(uses = { BookIdMapper.class, CharacterIdMapper.class })
    public interface BookToCharacterMapper /*extends DtoMapper<BookToCharacter, BookToCharacterDto>*/ {
        BookToCharacterMapper instance = getMapper(BookToCharacterMapper.class);
        BookToCharacterDto toDto(final BookToCharacter entity);
    }

}
