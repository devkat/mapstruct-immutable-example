package com.github.devkat.domain;

import org.immutables.value.Value;

@Value.Style(
        typeAbstract = "_*",
        typeImmutable = "*",
        visibility = Value.Style.ImplementationVisibility.PUBLIC,
        defaults = @Value.Immutable(builder = false, copy = false))
public @interface Wrapped {}
