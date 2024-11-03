package com.ced.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Prerequisite {
    @Field("ability_score")
    private APIReference abilityScore;

    @Field("minimum_score")
    private Integer minimumScore;
}

