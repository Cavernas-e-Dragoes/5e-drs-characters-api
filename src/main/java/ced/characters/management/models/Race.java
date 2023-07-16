package ced.characters.management.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "races")
public class Race {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private String name;
    private String description;
    private Integer speed;
    private List<String> traits;
    private List<String> abilityScoreIncrease;

    @DBRef
    private List<SubRace> subRaces;

}