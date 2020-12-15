package com.github.devkat.model;

import fj.data.Option;
import org.immutables.value.Value;

@Value.Immutable
public interface Character {

    String getName();

    Option<Species> getSpecies();

}
