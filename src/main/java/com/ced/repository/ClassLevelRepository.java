package com.ced.repository;


import com.ced.model.drs.classes.ClassLevel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassLevelRepository extends MongoRepository<ClassLevel, String> {
    List<ClassLevel> findByClassIndex(String classIndex);

    Optional<ClassLevel> findByClassIndexAndLevel(String classIndex, int level);
}
