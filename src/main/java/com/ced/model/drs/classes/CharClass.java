package com.ced.model.drs.classes;

import com.ced.model.APIReference;
import com.ced.model.Choice;
import com.ced.model.EquipmentQuantity;
import com.ced.model.MultiClassing;
import com.ced.model.ProficiencyChoice;
import com.ced.model.drs.spells.Spellcasting;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "classes")
public class CharClass {

    @EqualsAndHashCode.Include
    @Id
    private String id;

    private String index;
    private String name;

    @Field("hit_die")
    private Integer hitDie;

    @Field("proficiency_choices")
    private List<ProficiencyChoice> proficiencyChoices;

    private List<APIReference> proficiencies;

    @Field("saving_throws")
    private List<APIReference> savingThrows;

    @Field("starting_equipment")
    private List<EquipmentQuantity> startingEquipment;

    @Field("starting_equipment_options")
    private List<Choice> startingEquipmentOptions;

    @Field("class_levels")
    private String classLevels;

    @Field("multi_classing")
    private MultiClassing multiClassing;

    private List<APIReference> subclasses;

    private Spellcasting spellcasting;

    private String url;
}