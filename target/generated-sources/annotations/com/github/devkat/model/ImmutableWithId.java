package com.github.devkat.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link WithId}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableWithId.builder()}.
 */
@Generated(from = "WithId", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableWithId<ID, A> implements WithId<ID, A> {
  private final ID id;
  private final A data;

  private ImmutableWithId(ID id, A data) {
    this.id = id;
    this.data = data;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @Override
  public ID getId() {
    return id;
  }

  /**
   * @return The value of the {@code data} attribute
   */
  @Override
  public A getData() {
    return data;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WithId#getId() id} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWithId<ID, A> withId(ID value) {
    if (this.id == value) return this;
    ID newValue = Objects.requireNonNull(value, "id");
    return new ImmutableWithId<>(newValue, this.data);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WithId#getData() data} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for data
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWithId<ID, A> withData(A value) {
    if (this.data == value) return this;
    A newValue = Objects.requireNonNull(value, "data");
    return new ImmutableWithId<>(this.id, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableWithId} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableWithId<?, ?>
        && equalTo((ImmutableWithId<?, ?>) another);
  }

  private boolean equalTo(ImmutableWithId<?, ?> another) {
    return id.equals(another.id)
        && data.equals(another.data);
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code data}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + id.hashCode();
    h += (h << 5) + data.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code WithId} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "WithId{"
        + "id=" + id
        + ", data=" + data
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link WithId} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param <ID> generic parameter ID
   * @param <A> generic parameter A
   * @param instance The instance to copy
   * @return A copied immutable WithId instance
   */
  public static <ID, A> ImmutableWithId<ID, A> copyOf(WithId<ID, A> instance) {
    if (instance instanceof ImmutableWithId<?, ?>) {
      return (ImmutableWithId<ID, A>) instance;
    }
    return ImmutableWithId.<ID, A>builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableWithId ImmutableWithId}.
   * <pre>
   * ImmutableWithId.&amp;lt;ID, A&amp;gt;builder()
   *    .id(ID) // required {@link WithId#getId() id}
   *    .data(A) // required {@link WithId#getData() data}
   *    .build();
   * </pre>
   * @param <ID> generic parameter ID
   * @param <A> generic parameter A
   * @return A new ImmutableWithId builder
   */
  public static <ID, A> ImmutableWithId.Builder<ID, A> builder() {
    return new ImmutableWithId.Builder<>();
  }

  /**
   * Builds instances of type {@link ImmutableWithId ImmutableWithId}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "WithId", generator = "Immutables")
  public static final class Builder<ID, A> {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long INIT_BIT_DATA = 0x2L;
    private long initBits = 0x3L;

    private ID id;
    private A data;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code WithId} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder<ID, A> from(WithId<ID, A> instance) {
      Objects.requireNonNull(instance, "instance");
      id(instance.getId());
      data(instance.getData());
      return this;
    }

    /**
     * Initializes the value for the {@link WithId#getId() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder<ID, A> id(ID id) {
      this.id = Objects.requireNonNull(id, "id");
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link WithId#getData() data} attribute.
     * @param data The value for data 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder<ID, A> data(A data) {
      this.data = Objects.requireNonNull(data, "data");
      initBits &= ~INIT_BIT_DATA;
      return this;
    }

    /**
     * Builds a new {@link ImmutableWithId ImmutableWithId}.
     * @return An immutable instance of WithId
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableWithId<ID, A> build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableWithId<>(id, data);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_DATA) != 0) attributes.add("data");
      return "Cannot build WithId, some of required attributes are not set " + attributes;
    }
  }
}
