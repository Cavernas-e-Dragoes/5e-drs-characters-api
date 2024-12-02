package com.ced.model;

import com.ced.model.enums.Race;
import com.ced.model.enums.Subrace;
import com.ced.model.utils.Attributes;
import com.ced.model.enums.CharacterClass;
import com.ced.model.utils.Equipment;
import com.ced.model.utils.Progression;
import com.ced.model.utils.Skills;
import com.ced.model.utils.Spell;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static com.ced.constants.ApplicationConstants.PERSONAGENS;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = PERSONAGENS)
public class Character {

    @Id
    private String id;
    @Indexed
    @NotNull
    private String email;
    @NotNull
    private String name;

    private Integer inspiration;
    private Integer hitPoints;

    @NotNull
    private CharacterClass charClass;
    @NotNull
    private Race race;
    @NotNull
    private Subrace subRace;

    private Attributes attributes;
    private Skills skills;

    private List<Equipment> equipments;
    private List<Spell> spells;

    private Progression progression;
}
