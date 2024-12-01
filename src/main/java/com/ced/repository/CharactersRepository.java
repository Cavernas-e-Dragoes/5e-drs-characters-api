package com.ced.repository;

import com.ced.model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharactersRepository extends MongoRepository<Character, String> {
    List<Character> findAllByEmail(String login);
}
