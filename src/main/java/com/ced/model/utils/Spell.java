package com.ced.model.utils;

import java.util.List;

public record Spell(

        String index,
        String name,
        List<String> higherLevel,
        String range,
        List<String> components,
        String material,
        boolean ritual,
        String duration,
        boolean concentration,
        String castingTime,
        int level,
        String attackType,
        Object damage,
        AreaOfEffect areaOfEffect,
        String url
) {
    public record AreaOfEffect(
            String type,
            Double size,
            Double height,
            Double depth,
            Double width

    ) {
    }
}