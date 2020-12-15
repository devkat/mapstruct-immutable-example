package com.github.devkat.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link BookToCharacter}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableBookToCharacter.builder()}.
 */
@Generated(from = "BookToCharacter", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableBookToCharacter implements BookToCharacter {
  private final BookId bookId;
  private final CharacterId characterId;

  private ImmutableBookToCharacter(BookId bookId, CharacterId characterId) {
    this.bookId = bookId;
    this.characterId = characterId;
  }

  /**
   * @return The value of the {@code bookId} attribute
   */
  @Override
  public BookId getBookId() {
    return bookId;
  }

  /**
   * @return The value of the {@code characterId} attribute
   */
  @Override
  public CharacterId getCharacterId() {
    return characterId;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link BookToCharacter#getBookId() bookId} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for bookId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableBookToCharacter withBookId(BookId value) {
    if (this.bookId == value) return this;
    BookId newValue = Objects.requireNonNull(value, "bookId");
    return new ImmutableBookToCharacter(newValue, this.characterId);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link BookToCharacter#getCharacterId() characterId} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for characterId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableBookToCharacter withCharacterId(CharacterId value) {
    if (this.characterId == value) return this;
    CharacterId newValue = Objects.requireNonNull(value, "characterId");
    return new ImmutableBookToCharacter(this.bookId, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableBookToCharacter} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableBookToCharacter
        && equalTo((ImmutableBookToCharacter) another);
  }

  private boolean equalTo(ImmutableBookToCharacter another) {
    return bookId.equals(another.bookId)
        && characterId.equals(another.characterId);
  }

  /**
   * Computes a hash code from attributes: {@code bookId}, {@code characterId}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + bookId.hashCode();
    h += (h << 5) + characterId.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code BookToCharacter} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "BookToCharacter{"
        + "bookId=" + bookId
        + ", characterId=" + characterId
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link BookToCharacter} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable BookToCharacter instance
   */
  public static ImmutableBookToCharacter copyOf(BookToCharacter instance) {
    if (instance instanceof ImmutableBookToCharacter) {
      return (ImmutableBookToCharacter) instance;
    }
    return ImmutableBookToCharacter.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableBookToCharacter ImmutableBookToCharacter}.
   * <pre>
   * ImmutableBookToCharacter.builder()
   *    .bookId(com.github.devkat.model.BookId) // required {@link BookToCharacter#getBookId() bookId}
   *    .characterId(com.github.devkat.model.CharacterId) // required {@link BookToCharacter#getCharacterId() characterId}
   *    .build();
   * </pre>
   * @return A new ImmutableBookToCharacter builder
   */
  public static ImmutableBookToCharacter.Builder builder() {
    return new ImmutableBookToCharacter.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableBookToCharacter ImmutableBookToCharacter}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "BookToCharacter", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_BOOK_ID = 0x1L;
    private static final long INIT_BIT_CHARACTER_ID = 0x2L;
    private long initBits = 0x3L;

    private BookId bookId;
    private CharacterId characterId;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code BookToCharacter} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(BookToCharacter instance) {
      Objects.requireNonNull(instance, "instance");
      bookId(instance.getBookId());
      characterId(instance.getCharacterId());
      return this;
    }

    /**
     * Initializes the value for the {@link BookToCharacter#getBookId() bookId} attribute.
     * @param bookId The value for bookId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder bookId(BookId bookId) {
      this.bookId = Objects.requireNonNull(bookId, "bookId");
      initBits &= ~INIT_BIT_BOOK_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link BookToCharacter#getCharacterId() characterId} attribute.
     * @param characterId The value for characterId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder characterId(CharacterId characterId) {
      this.characterId = Objects.requireNonNull(characterId, "characterId");
      initBits &= ~INIT_BIT_CHARACTER_ID;
      return this;
    }

    /**
     * Builds a new {@link ImmutableBookToCharacter ImmutableBookToCharacter}.
     * @return An immutable instance of BookToCharacter
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableBookToCharacter build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableBookToCharacter(bookId, characterId);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_BOOK_ID) != 0) attributes.add("bookId");
      if ((initBits & INIT_BIT_CHARACTER_ID) != 0) attributes.add("characterId");
      return "Cannot build BookToCharacter, some of required attributes are not set " + attributes;
    }
  }
}
