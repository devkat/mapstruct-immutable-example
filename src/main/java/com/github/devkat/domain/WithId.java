package com.github.devkat.domain;

import org.immutables.value.Value;

@Value.Immutable @Tuple
public interface WithId<ID, A> {

    ID getId();

    A getData();

}
