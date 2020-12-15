package com.github.devkat.persistence.mapping;

import com.github.devkat.model.BookId;

public class BookIdMapper {

    public BookId asBookId(final int id) {
        return BookId.of(id);
    }

    public int asInt(final BookId bookId) {
        return bookId.value();
    }

}
