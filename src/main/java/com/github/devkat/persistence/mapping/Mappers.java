package com.github.devkat.persistence.mapping;

import com.github.devkat.model.Book;
import com.github.devkat.model.Character;
import com.github.devkat.persistence.dto.BookDto;
import com.github.devkat.persistence.dto.CharacterDto;
import org.mapstruct.Mapper;

public final class Mappers {

    @Mapper
    public interface BookMapper extends DtoMapper<Book, BookDto> {
        BookMapper instance = org.mapstruct.factory.Mappers.getMapper(BookMapper.class);
    }

    @Mapper
    public interface CharacterMapper extends DtoMapper<Character, CharacterDto> {
        CharacterMapper instance = org.mapstruct.factory.Mappers.getMapper(CharacterMapper.class);
    }

}