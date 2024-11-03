package com.ced.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class From {
    @Field("option_set_type")
    private String optionSetType;
    private List<Option> options;

    @Field("equipment_category")
    private APIReference equipmentCategory;
}
