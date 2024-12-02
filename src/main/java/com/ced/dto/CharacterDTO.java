package com.ced.dto;

import com.ced.model.enums.Race;
import com.ced.model.enums.Subrace;
import com.ced.model.utils.Attributes;
import com.ced.model.enums.CharacterClass;
import com.ced.model.utils.Equipment;
import com.ced.model.utils.Progression;
import com.ced.model.utils.Skills;
import com.ced.model.utils.Spell;

import java.util.List;

public record CharacterDTO(
        String id,
        String name,
        Integer inspiration,
        Integer hitPoints,
        Race race,
        Subrace subRace,
        CharacterClass charClass,
        Attributes attributes,
        Skills skills,
        List<Equipment> equipments,
        List<Spell> spells,
        Progression progression,
        Integer strengthModifier,
        Integer dexterityModifier,
        Integer constitutionModifier,
        Integer intelligenceModifier,
        Integer wisdomModifier,
        Integer charismaModifier,
        Integer proficiencyBonus
) {
}
