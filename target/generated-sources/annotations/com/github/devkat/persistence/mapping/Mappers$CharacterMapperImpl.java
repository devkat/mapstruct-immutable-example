package com.github.devkat.persistence.mapping;

import com.github.devkat.model.Character;
import com.github.devkat.model.ImmutableCharacter;
import com.github.devkat.model.ImmutableCharacter.Builder;
import com.github.devkat.persistence.dto.CharacterDto;
import com.github.devkat.persistence.mapping.Mappers.CharacterMapper;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-15T17:39:15+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class Mappers$CharacterMapperImpl implements CharacterMapper {

    @Override
    public CharacterDto toDto(Character arg0) {
        if ( arg0 == null ) {
            return null;
        }

        CharacterDto characterDto = new CharacterDto();

        characterDto.setName( arg0.getName() );
        characterDto.setSpecies( arg0.getSpecies() );

        return characterDto;
    }

    @Override
    public Character fromDto(CharacterDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Builder character = ImmutableCharacter.builder();

        character.name( arg0.getName() );
        character.species( arg0.getSpecies() );

        return character.build();
    }
}
