package com.github.devkat.domain;

import org.immutables.value.Value;

@Value.Style(
        allParameters = true,
        typeImmutable = "Immutable*")
public @interface Tuple {}