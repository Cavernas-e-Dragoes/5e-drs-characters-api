package com.ced.characters.vo;

import lombok.Getter;
import lombok.Setter;
import com.ced.characters.models.CharacterSheet;

@Getter
@Setter
public class CharacterSheetDTO extends CharacterSheet {

    private Integer strengthModifier;
    private Integer dexterityModifier;
    private Integer constitutionModifier;
    private Integer intelligenceModifier;
    private Integer wisdomModifier;
    private Integer charismaModifier;
    private Integer proficiencyBonus;

}
