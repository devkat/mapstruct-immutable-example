package com.github.devkat.model;

import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link _CharacterId}.
 * <p>
 * Use the static factory method to create immutable instances:
 * {@code CharacterId.of()}.
 */
@Generated(from = "_CharacterId", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
public final class CharacterId extends com.github.devkat.model._CharacterId {
  private final Integer value;

  private CharacterId(Integer value) {
    this.value = Objects.requireNonNull(value, "value");
  }

  /**
   * @return The value of the {@code value} attribute
   */
  @Override
  public Integer value() {
    return value;
  }

  /**
   * This instance is equal to all instances of {@code CharacterId} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof CharacterId
        && equalTo((CharacterId) another);
  }

  private boolean equalTo(CharacterId another) {
    return value.equals(another.value);
  }

  /**
   * Computes a hash code from attributes: {@code value}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + value.hashCode();
    return h;
  }

  /**
   * Construct a new immutable {@code CharacterId} instance.
   * @param value The value for the {@code value} attribute
   * @return An immutable CharacterId instance
   */
  public static CharacterId of(Integer value) {
    return new CharacterId(value);
  }
}
