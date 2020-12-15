package com.github.devkat.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Book}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableBook.builder()}.
 */
@Generated(from = "Book", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableBook implements Book {
  private final String title;

  private ImmutableBook(String title) {
    this.title = title;
  }

  /**
   * @return The value of the {@code title} attribute
   */
  @Override
  public String getTitle() {
    return title;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Book#getTitle() title} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for title
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableBook withTitle(String value) {
    String newValue = Objects.requireNonNull(value, "title");
    if (this.title.equals(newValue)) return this;
    return new ImmutableBook(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableBook} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableBook
        && equalTo((ImmutableBook) another);
  }

  private boolean equalTo(ImmutableBook another) {
    return title.equals(another.title);
  }

  /**
   * Computes a hash code from attributes: {@code title}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + title.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Book} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Book{"
        + "title=" + title
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link Book} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Book instance
   */
  public static ImmutableBook copyOf(Book instance) {
    if (instance instanceof ImmutableBook) {
      return (ImmutableBook) instance;
    }
    return ImmutableBook.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableBook ImmutableBook}.
   * <pre>
   * ImmutableBook.builder()
   *    .title(String) // required {@link Book#getTitle() title}
   *    .build();
   * </pre>
   * @return A new ImmutableBook builder
   */
  public static ImmutableBook.Builder builder() {
    return new ImmutableBook.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableBook ImmutableBook}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Book", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_TITLE = 0x1L;
    private long initBits = 0x1L;

    private String title;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Book} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Book instance) {
      Objects.requireNonNull(instance, "instance");
      title(instance.getTitle());
      return this;
    }

    /**
     * Initializes the value for the {@link Book#getTitle() title} attribute.
     * @param title The value for title 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder title(String title) {
      this.title = Objects.requireNonNull(title, "title");
      initBits &= ~INIT_BIT_TITLE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableBook ImmutableBook}.
     * @return An immutable instance of Book
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableBook build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableBook(title);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_TITLE) != 0) attributes.add("title");
      return "Cannot build Book, some of required attributes are not set " + attributes;
    }
  }
}
