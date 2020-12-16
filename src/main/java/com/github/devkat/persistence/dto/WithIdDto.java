package com.github.devkat.persistence.dto;

import com.github.devkat.domain.WithId;

public interface WithIdDto<ID, A> {

    WithId<ID, A> toEntity();

}
