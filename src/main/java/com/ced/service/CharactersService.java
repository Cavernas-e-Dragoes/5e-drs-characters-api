package com.ced.service;

import com.ced.dto.CharacterDTO;
import com.ced.dto.CharactersListDTO;
import com.ced.model.Character;
import com.ced.model.utils.Progression;
import com.ced.repository.CharactersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ced.utils.Calcs.calcInitialHT;
import static com.ced.utils.Calcs.calculateModifier;
import static com.ced.utils.Calcs.getProficiencyBonus;

@Service
public class CharactersService {

    private final CharactersRepository charactersRepository;

    public CharactersService(final CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }

    public List<CharactersListDTO> findAll(String email) {
        List<Character> characters = charactersRepository.findAllByEmail(email);
        return characters.stream()
                .map(this::convertToDtoList)
                .collect(Collectors.toList());
    }

    public CharacterDTO findById(String email, String id) {
        Character character = charactersRepository.findById(id)
                .filter(c -> c.getEmail().equals(email))
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado ou não pertence ao usuário."));
        return mapToDTO(character);
    }

    private CharactersListDTO convertToDtoList(Character character) {
        return new CharactersListDTO(
                character.getId(),
                character.getRace(),
                character.getCharClass().name(),
                character.getName(),
                character.getProgression().getLevel()
        );
    }

    public CharacterDTO mapToDTO(Character character) {
        return new CharacterDTO(
                character.getId(),
                character.getName(),
                character.getInspiration(),
                character.getHitPoints(),
                character.getRace(),
                character.getSubRace(),
                character.getCharClass(),
                character.getAttributes(),
                character.getSkills(),
                character.getEquipments(),
                character.getSpells(),
                character.getProgression(),
                calculateModifier(character.getAttributes().getStrength()),
                calculateModifier(character.getAttributes().getDexterity()),
                calculateModifier(character.getAttributes().getConstitution()),
                calculateModifier(character.getAttributes().getIntelligence()),
                calculateModifier(character.getAttributes().getWisdom()),
                calculateModifier(character.getAttributes().getCharisma()),
                getProficiencyBonus(character.getProgression().getLevel())
        );
    }

    public Character save(final String email, final Character character) {

        if (character.getProgression() == null) {
            character.setProgression(new Progression());
        }

        character.setHitPoints(calcInitialHT(character.getCharClass().getHitDie(),
                calculateModifier(character.getAttributes().getConstitution())));
        character.setEmail(email);

        return charactersRepository.save(character);
    }
}
