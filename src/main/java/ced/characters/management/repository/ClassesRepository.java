package ced.characters.management.repository;

import ced.characters.management.models.CharClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassesRepository extends MongoRepository<CharClass, String> {
     Optional<CharClass> findById(String id);
}
