package com.ced.model.drs.spells;

import com.ced.model.APIReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Spellcasting {

    private Integer level;

    @JsonProperty("spellcasting_ability")
    private APIReference spellcastingAbility;

    private List<SpellcastingInfo> info;
}
