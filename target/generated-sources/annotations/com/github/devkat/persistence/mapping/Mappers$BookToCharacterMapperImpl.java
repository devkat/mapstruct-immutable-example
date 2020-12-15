package com.github.devkat.persistence.mapping;

import com.github.devkat.model.BookToCharacter;
import com.github.devkat.persistence.dto.BookToCharacterDto;
import com.github.devkat.persistence.mapping.Mappers.BookToCharacterMapper;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-15T17:39:15+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class Mappers$BookToCharacterMapperImpl implements BookToCharacterMapper {

    private final BookIdMapper bookIdMapper = new BookIdMapper();
    private final CharacterIdMapper characterIdMapper = new CharacterIdMapper();

    @Override
    public BookToCharacterDto toDto(BookToCharacter entity) {
        if ( entity == null ) {
            return null;
        }

        BookToCharacterDto bookToCharacterDto = new BookToCharacterDto();

        bookToCharacterDto.setBookId( bookIdMapper.asInt( entity.getBookId() ) );
        bookToCharacterDto.setCharacterId( characterIdMapper.asInt( entity.getCharacterId() ) );

        return bookToCharacterDto;
    }
}
