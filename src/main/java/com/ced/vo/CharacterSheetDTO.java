package com.ced.vo;

import com.ced.model.character.CharacterSheet;
import lombok.Getter;
import lombok.Setter;

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
