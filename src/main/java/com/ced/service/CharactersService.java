package com.ced.service;

import com.ced.dto.CharactersListSheetDTO;
import com.ced.exception.EntityNotFoundException;
import com.ced.model.Character;
import com.ced.model.utils.Progression;
import com.ced.repository.CharactersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.ced.utils.Calcs.calcInitialHT;
import static com.ced.utils.Calcs.convertAttribute;

@Service
public class CharactersService {

    private final CharactersRepository charactersRepository;

    public CharactersService(final CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }

    public List<CharactersListSheetDTO> findAll(final String email) {
        List<Character> characterList = charactersRepository.findAllByEmail(email);

        return characterList.stream()
                .map(this::convertToDtoList)
                .collect(Collectors.toList());
    }

    public Character findById(final String email, final String id) {
        return charactersRepository.findById(id)
                .filter(character -> character.getEmail().equals(email))
                .orElseThrow(() -> new EntityNotFoundException("CharacterSheet não encontrado ou não pertence ao usuário fornecido."));
    }

    private CharactersListSheetDTO convertToDtoList(Character character) {
        return new CharactersListSheetDTO(
                character.getId(),
                character.getRace(),
                character.getCharClass().name(),
                character.getName(),
                character.getProgression().getLevel()
        );
    }

    public Character save(final String email, final Character character) {

        if (character.getProgression() == null) {
            character.setProgression(new Progression());
        }

        character.setHitPoints(calcInitialHT(character.getCharClass().getHitDie(),
                convertAttribute(character.getAttributes().getConstitution())));
        character.setEmail(email);

        return charactersRepository.save(character);
    }
}
