package com.ced.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "magics")
public class Magic {

    @EqualsAndHashCode.Include
    @Id
    private String id;

    private String name;
    private String description;
    private String level;
    private String school;
    private String castingTime;
    private String range;
    private String components;
    private String duration;
    private Boolean concentration;
    private Boolean ritual;

}
