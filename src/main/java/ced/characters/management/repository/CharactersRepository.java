package ced.characters.management.repository;

import ced.characters.management.models.CharacterSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharactersRepository extends JpaRepository<CharacterSheet, Long> {

    public List<CharacterSheet> findAllByLogin(String login);


}