package com.ced.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class Damage {
    private Object damage_type;
    private Map<String, String> damage_at_slot_level;

    @JsonIgnore
    public List<APIReference> getDamageTypeList() {
        if (damage_type instanceof List<?>) {
            return (List<APIReference>) damage_type;
        } else if (damage_type instanceof APIReference) {
            List<APIReference> list = new ArrayList<>();
            list.add((APIReference) damage_type);
            return list;
        }
        return new ArrayList<>();
    }

    @JsonSetter("damage_type")
    public void setDamage_type(Object damage_type) {
        this.damage_type = damage_type;
    }
}
