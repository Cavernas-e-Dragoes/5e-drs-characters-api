package com.ced.model.drs.classes;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "class_levels")
public class ClassLevel {

    @Id
    private String id;
    private String classIndex;
    private int level;
}
