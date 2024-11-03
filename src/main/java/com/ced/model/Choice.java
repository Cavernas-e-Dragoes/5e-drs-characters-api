package com.ced.model;

import lombok.Data;

@Data
public class Choice {
    private String desc;
    private Integer choose;
    private String type;
    private From from;
}

