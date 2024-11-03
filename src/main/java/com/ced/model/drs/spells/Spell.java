package com.ced.model.drs.spells;

import com.ced.model.APIReference;
import com.ced.model.DC;
import com.ced.model.Damage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "spells")
public class Spell {

    @EqualsAndHashCode.Include
    @Id
    private String id;

    private String index;
    private String name;

    private List<String> desc;

    @Field("higher_level")
    private List<String> higherLevel;

    private String range;
    private List<String> components;
    private String material;
    private boolean ritual;
    private String duration;
    private boolean concentration;

    @Field("casting_time")
    private String castingTime;

    private int level;

    @Field("attack_type")
    private String attackType;

    private Damage damage;

    @Field("area_of_effect")
    private AreaOfEffect areaOfEffect;

    private DC dc;

    private APIReference school;

    private List<APIReference> classes;

    private List<APIReference> subclasses;

    private String url;
}
