package com.github.devkat.model;

import java.util.Objects;

public abstract class Val<A> {

    public final A value;

    public Val(A value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Val<?> value1 = (Val<?>) o;
        return value.equals(value1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
