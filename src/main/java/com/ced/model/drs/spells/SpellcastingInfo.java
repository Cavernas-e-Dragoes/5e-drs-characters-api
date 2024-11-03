package com.ced.model.drs.spells;

import lombok.Data;

import java.util.List;

@Data
public class SpellcastingInfo {
    private String name;
    private List<String> desc;
}
