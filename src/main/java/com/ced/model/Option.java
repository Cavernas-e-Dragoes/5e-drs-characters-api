package com.ced.model;

import lombok.Data;

@Data
public class Option {
    private String optionType;
    private Integer count;
    private APIReference item;
    private Choice choice;
    private APIReference of;
}

