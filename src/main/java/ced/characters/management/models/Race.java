package ced.characters.management.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Race {

    @Id
    private Long id;

    private String name;
}
