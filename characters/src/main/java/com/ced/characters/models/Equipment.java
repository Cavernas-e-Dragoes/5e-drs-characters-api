package com.ced.characters.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "equipments")
public class Equipment {

    @EqualsAndHashCode.Include
    @Id
    private String id;

    private String name;
    private String type;
    private Integer price;
    private String description;
    private Integer weight;
    private String damage;
    private String properties;
    private Boolean stealth;
    private Boolean strength;
}
