package com.ced.model.utils;

import lombok.Data;

@Data
public class Progression {
    private Integer level;
    private Integer experiencePoints;
    private String alignment;

    public Progression() {
        this.level = 1;
        this.experiencePoints = 0;
    }

}
