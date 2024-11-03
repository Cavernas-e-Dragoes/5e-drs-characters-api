package com.ced.repository;

import com.ced.model.drs.races.Race;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RacesRepository extends MongoRepository<Race, String> {
    Optional<Race> findByIndex(String index);
}
