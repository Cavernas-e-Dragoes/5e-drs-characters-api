package com.ced.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
class AbilityBonus {
    @Field("ability_score")
    private APIReference abilityScore;
    private Integer bonus;
}