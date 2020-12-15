package com.github.devkat.persistence.dto;

import javax.persistence.*;

import com.github.devkat.model.*;
import com.github.devkat.model.Character;
import com.github.devkat.persistence.conversion.OptionConverter;
import com.github.devkat.persistence.mapping.Mappers;
import fj.data.Option;

@Entity
public class CharacterDto implements WithIdDto<CharacterId, Character> {

    @Override
    public WithId<CharacterId, Character> toEntity() {
        return ImmutableWithId.<CharacterId, Character>builder()
                .id(CharacterId.of(id))
                .data(Mappers.CharacterMapper.instance.fromDto(this))
                .build();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.ORDINAL)
    @Convert(converter = OptionConverter.class)
    private Option<Species> species;

    public Option<Species> getSpecies() {
        return species;
    }

    public void setSpecies(final Option<Species> species) {
        this.species = species;
    }

}
