package com.github.devkat.model;

import org.immutables.value.Value;

@Value.Immutable
public interface WithId<ID, A> {

    ID getId();

    A getData();

}
