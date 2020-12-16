package com.github.devkat.persistence.mapping;

import com.github.devkat.domain.CharacterId;

public class CharacterIdMapper {

    public CharacterId asCharacterId(final int id) {
        return CharacterId.of(id);
    }

    public int asInt(final CharacterId CharacterId) {
        return CharacterId.value();
    }

}
