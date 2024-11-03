package com.ced.repository;

import com.ced.model.drs.spells.Spell;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpellsRepository extends MongoRepository<Spell, String> {
    Optional<Spell> findByIndex(String index);
}
