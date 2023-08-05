package com.ced.config;

import com.ced.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;

@Configuration
public class MongoConfig {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void createIndexes() {
        IndexOperations indexOps = mongoTemplate.indexOps(User.class);
        Index index = new Index().on("email", Sort.Direction.ASC).unique();
        indexOps.ensureIndex(index);
    }
}