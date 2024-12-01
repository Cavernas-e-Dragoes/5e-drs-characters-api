package com.ced.dto;

public record CharacterSheetDTO(
        Integer strengthModifier,
        Integer dexterityModifier,
        Integer constitutionModifier,
        Integer intelligenceModifier,
        Integer wisdomModifier,
        Integer charismaModifier,
        Integer proficiencyBonus
) {
}
