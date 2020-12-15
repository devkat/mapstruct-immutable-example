package com.github.devkat.persistence.conversion;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import fj.data.Option;

@Converter
public class OptionConverter implements AttributeConverter<Option<Object>, Object> {

    @Override
    public Object convertToDatabaseColumn(final Option<Object> ts) {
        return ts.toNull();
    }

    @Override
    public Option<Object> convertToEntityAttribute(final Object t) {
        return Option.fromNull(t);
    }
}
