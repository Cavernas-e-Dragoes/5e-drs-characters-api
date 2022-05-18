package ced.characters.management.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CharClass {
    private Long id;

    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
