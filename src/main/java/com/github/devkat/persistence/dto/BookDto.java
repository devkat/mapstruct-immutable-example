package com.github.devkat.persistence.dto;

import javax.persistence.*;

import com.github.devkat.model.Book;
import com.github.devkat.model.BookId;
import com.github.devkat.model.ImmutableWithId;
import com.github.devkat.model.WithId;
import com.github.devkat.persistence.mapping.Mappers;

@Entity
public class BookDto {

    public WithId<BookId, Book> toEntity() {
        return ImmutableWithId.<BookId, Book>builder()
                .id(new BookId(id))
                .data(Mappers.BookMapper.instance.fromDto(this))
                .build();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

}
