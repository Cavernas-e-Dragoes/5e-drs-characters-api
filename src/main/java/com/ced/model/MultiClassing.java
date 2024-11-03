package com.ced.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class MultiClassing {
    private List<Prerequisite> prerequisites;

    @Field("proficiency_choices")
    private List<ProficiencyChoice> proficiencyChoices;

    private List<APIReference> proficiencies;
}

