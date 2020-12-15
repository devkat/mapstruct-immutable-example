package com.github.devkat.persistence.mapping;

import com.github.devkat.model.Character;
import com.github.devkat.model.ImmutableCharacter;
import com.github.devkat.model.ImmutableCharacter.Builder;
import com.github.devkat.persistence.dto.CharacterDto;
import com.github.devkat.persistence.mapping.Mappers.CharacterMapper;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-15T15:13:44+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class Mappers$CharacterMapperImpl implements CharacterMapper {

    @Override
    public CharacterDto toDto(Character entity) {
        if ( entity == null ) {
            return null;
        }

        CharacterDto characterDto = new CharacterDto();

        return characterDto;
    }

    @Override
    public Character fromDto(CharacterDto dto) {
        if ( dto == null ) {
            return null;
        }

        Builder character = ImmutableCharacter.builder();

        return character.build();
    }
}
