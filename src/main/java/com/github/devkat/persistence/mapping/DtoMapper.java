package com.github.devkat.persistence.mapping;

public interface DtoMapper<E, D> {

    D toDto(final E entity);

    E fromDto(final D dto);

}
