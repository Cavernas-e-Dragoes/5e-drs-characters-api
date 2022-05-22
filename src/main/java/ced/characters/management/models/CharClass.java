package ced.characters.management.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class CharClass {

    @Id
    private Long id;

    private String name;

    private Integer hitDice;

}
