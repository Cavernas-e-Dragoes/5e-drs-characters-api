package com.ced.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class DC {
    @Field("dc_type")
    private APIReference dcType;

    @Field("dc_success")
    private String dcSuccess;
}
