package com.ced.characters.repository;


import com.ced.characters.models.CharClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassesRepository extends MongoRepository<CharClass, String> {
     Optional<CharClass> findById(String id);
}
