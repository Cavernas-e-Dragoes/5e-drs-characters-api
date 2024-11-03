package com.ced.model.drs.races;

import com.ced.model.APIReference;
import com.ced.model.AbilityBonus;
import com.ced.model.ProficiencyOptions;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "races")
public class Race {

    @EqualsAndHashCode.Include
    @Id
    private String id;

    private String index;
    private String name;
    private Double speed;

    @Field("ability_bonuses")
    private List<AbilityBonus> abilityBonuses;

    private String alignment;
    private String age;
    private String size;

    @Field("size_description")
    private String sizeDescription;

    @Field("starting_proficiencies")
    private List<APIReference> startingProficiencies;

    @Field("starting_proficiency_options")
    private ProficiencyOptions startingProficiencyOptions;

    private List<APIReference> languages;

    @Field("language_desc")
    private String languageDesc;

    private List<APIReference> traits;
    private List<APIReference> subraces;
    private String url;

}





