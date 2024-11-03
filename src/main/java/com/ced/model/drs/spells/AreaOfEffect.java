package com.ced.model.drs.spells;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AreaOfEffect {
    private String type;
    private Double size;
    private Double height;
    private Double depth;
    private Double width;

}
