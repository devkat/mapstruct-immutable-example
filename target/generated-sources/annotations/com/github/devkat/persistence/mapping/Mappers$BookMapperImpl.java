package com.github.devkat.persistence.mapping;

import com.github.devkat.model.Book;
import com.github.devkat.model.ImmutableBook;
import com.github.devkat.model.ImmutableBook.Builder;
import com.github.devkat.persistence.dto.BookDto;
import com.github.devkat.persistence.mapping.Mappers.BookMapper;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-12-15T17:39:15+0100",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
public class Mappers$BookMapperImpl implements BookMapper {

    @Override
    public BookDto toDto(Book arg0) {
        if ( arg0 == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        bookDto.setTitle( arg0.getTitle() );

        return bookDto;
    }

    @Override
    public Book fromDto(BookDto arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Builder book = ImmutableBook.builder();

        book.title( arg0.getTitle() );

        return book.build();
    }
}
