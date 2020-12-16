package com.github.devkat.domain;

import fj.data.Option;
import org.immutables.value.Value;

@Value.Immutable @Tuple
public interface Character {

    String getName();

    Option<Species> getSpecies();

}
