package ced.characters.management.repository;

import ced.characters.management.models.CharacterSheet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharactersRepository extends MongoRepository<CharacterSheet, String> {
     List<CharacterSheet> findAllByLogin(String login);
     Optional<CharacterSheet> findByName(String name);
}
