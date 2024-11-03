package com.ced.model;

import lombok.Data;

@Data
public class EquipmentQuantity {
    private APIReference equipment;
    private Integer quantity;
}
