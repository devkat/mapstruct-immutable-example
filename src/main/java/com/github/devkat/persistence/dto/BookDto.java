package com.github.devkat.persistence.dto;

import javax.persistence.*;

import com.github.devkat.domain.*;
import com.github.devkat.persistence.mapping.Mappers;

@Entity
public class BookDto implements WithIdDto<BookId, Book> {

    @Override
    public WithId<BookId, Book> toEntity() {
        return ImmutableWithId.of(
                BookId.of(id),
                Mappers.BookMapper.instance.fromDto(this)
        );
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
