package com.github.devkat.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Character}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCharacter.builder()}.
 */
@Generated(from = "Character", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableCharacter implements Character {
  private final String name;

  private ImmutableCharacter(String name) {
    this.name = name;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Character#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCharacter withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableCharacter(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCharacter} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCharacter
        && equalTo((ImmutableCharacter) another);
  }

  private boolean equalTo(ImmutableCharacter another) {
    return name.equals(another.name);
  }

  /**
   * Computes a hash code from attributes: {@code name}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Character} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Character{"
        + "name=" + name
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link Character} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Character instance
   */
  public static ImmutableCharacter copyOf(Character instance) {
    if (instance instanceof ImmutableCharacter) {
      return (ImmutableCharacter) instance;
    }
    return ImmutableCharacter.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCharacter ImmutableCharacter}.
   * <pre>
   * ImmutableCharacter.builder()
   *    .name(String) // required {@link Character#getName() name}
   *    .build();
   * </pre>
   * @return A new ImmutableCharacter builder
   */
  public static ImmutableCharacter.Builder builder() {
    return new ImmutableCharacter.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCharacter ImmutableCharacter}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Character", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private long initBits = 0x1L;

    private String name;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Character} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Character instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.getName());
      return this;
    }

    /**
     * Initializes the value for the {@link Character#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Builds a new {@link ImmutableCharacter ImmutableCharacter}.
     * @return An immutable instance of Character
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCharacter build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCharacter(name);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      return "Cannot build Character, some of required attributes are not set " + attributes;
    }
  }
}
