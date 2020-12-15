package com.github.devkat.persistence.dto;

import com.github.devkat.model.WithId;

public interface WithIdDto<ID, A> {

    WithId<ID, A> toEntity();

}
