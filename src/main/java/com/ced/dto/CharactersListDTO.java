package com.ced.dto;

import com.ced.model.enums.Race;

public record CharactersListDTO(
        String id,
        Race raceName,
        String className,
        String name,
        Integer level
) {
}
