package com.github.devkat.domain;

import org.immutables.value.Value;

@Value.Immutable @Tuple
public interface Book {

    String getTitle();

}
