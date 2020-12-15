package com.github.devkat.model;

import org.immutables.value.Value;

@Value.Immutable
public interface Book {

    String getTitle();

}
