package com.ced.characters.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "sub_races")
public class SubRace {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private String name;
    private String description;
    private List<String> traits;
    private List<String> abilityScoreIncrease;

}