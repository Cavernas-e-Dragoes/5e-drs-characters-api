package com.ced.model;

import com.ced.model.utils.Attributes;
import com.ced.model.utils.CharacterClass;
import com.ced.model.utils.Progression;
import com.ced.model.utils.Skills;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "personagens")
public class Character {

    @Id
    private String id;
    @Indexed
    private String email;

    private String name;
    private String race;
    private String subRace;
    private Integer inspiration;
    private Integer hitPoints;

    @NotNull
    private CharacterClass charClass;

    private Attributes attributes;
    private Skills skills;

    private List<Object> equipments;
    private List<Object> magics;

    private Progression progression;
}
