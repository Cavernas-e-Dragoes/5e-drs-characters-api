package com.ced.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "classes")
public class CharClass {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private Integer hitDice;
    private String name;
    private String description;
    private List<String> armorWeaponProficiencies;
    private List<String> primaryAbility;
    private List<String> savingProficiencies;

}