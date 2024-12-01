package com.ced.config;

import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

@ReadingConverter
@Component
public class NumberIntConverter implements Converter<Document, Integer> {

    @Override
    public Integer convert(Document source) {
        Object numberInt = source.get("$numberInt");
        if (numberInt != null) {
            try {
                return Integer.parseInt(numberInt.toString());
            } catch (NumberFormatException e) {
                // Log a exceção se necessário
                return null;
            }
        }
        return null;
    }
}
