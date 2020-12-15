package com.github.devkat.persistence.mapping;

import com.github.devkat.model.Book;
import com.github.devkat.model.ImmutableBook;
import com.github.devkat.model.ImmutableBook.Builder;
import com.github.devkat.persistence.dto.BookDto;
import com.github.devkat.persistence.mapping.Mappers.BookMapper;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-15T15:13:43+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class Mappers$BookMapperImpl implements BookMapper {

    @Override
    public BookDto toDto(Book entity) {
        if ( entity == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        return bookDto;
    }

    @Override
    public Book fromDto(BookDto dto) {
        if ( dto == null ) {
            return null;
        }

        Builder book = ImmutableBook.builder();

        return book.build();
    }
}
