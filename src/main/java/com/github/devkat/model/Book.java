package com.github.devkat.model;

import org.immutables.value.Value;

@Value.Immutable @Tuple
public interface Book {

    String getTitle();

}
