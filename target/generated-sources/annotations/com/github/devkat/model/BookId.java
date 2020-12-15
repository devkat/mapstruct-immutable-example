package com.github.devkat.model;

import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link _BookId}.
 * <p>
 * Use the static factory method to create immutable instances:
 * {@code BookId.of()}.
 */
@Generated(from = "_BookId", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
public final class BookId extends com.github.devkat.model._BookId {
  private final Integer value;

  private BookId(Integer value) {
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
   * This instance is equal to all instances of {@code BookId} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof BookId
        && equalTo((BookId) another);
  }

  private boolean equalTo(BookId another) {
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
   * Construct a new immutable {@code BookId} instance.
   * @param value The value for the {@code value} attribute
   * @return An immutable BookId instance
   */
  public static BookId of(Integer value) {
    return new BookId(value);
  }
}
