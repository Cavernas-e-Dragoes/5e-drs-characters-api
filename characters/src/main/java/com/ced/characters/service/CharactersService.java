package com.ced.characters.service;


import com.ced.characters.exception.EntityNotFoundException;
import com.ced.characters.models.CharacterSheet;
import com.ced.characters.repository.CharactersRepository;
import com.ced.characters.repository.ClassesRepository;
import com.ced.characters.vo.CharacterSheetDTO;
import com.ced.characters.vo.CharactersListSheetDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class CharactersService {

    private final CharactersRepository charactersRepository;
    private final ClassesRepository classesRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public CharactersService(final CharactersRepository charactersRepository,
                             final ClassesRepository classesRepository) {
        this.charactersRepository = charactersRepository;
        this.classesRepository = classesRepository;
    }

    public List<CharactersListSheetDTO> findAll(final String email) {
        List<CharactersListSheetDTO> charactersSheetDTOS = new ArrayList<>();

        List<CharacterSheet> characterSheetList = charactersRepository.findAllByEmail(email);

        for (CharacterSheet characterSheet : characterSheetList) {

            CharactersListSheetDTO charactersSheetDTO = convertToDtoList(characterSheet);
           // charactersSheetDTO.setRaceName(characterSheet.getRace().getName());
            //charactersSheetDTO.setClassName(characterSheet.getCharClass().getName());

            charactersSheetDTOS.add(charactersSheetDTO);
        }

        return charactersSheetDTOS;
    }

    public CharacterSheet findById(final String email, final String id) {
        Optional<CharacterSheet> characterSheetOptional = charactersRepository.findById(id);

        if (characterSheetOptional.isPresent()) {
            CharacterSheet characterSheet = characterSheetOptional.get();
            if (characterSheet.getEmail().equals(email)) {
                return characterSheet;
            } else {
                throw new EntityNotFoundException("O CharacterSheet não pertence ao usuário fornecido.");
            }
        } else {
            throw new EntityNotFoundException("CharacterSheet não encontrado com o ID fornecido.");
        }
    }

    private CharactersListSheetDTO convertToDtoList(CharacterSheet characterSheet) {
        return modelMapper.map(characterSheet, CharactersListSheetDTO.class);
    }

    private CharacterSheetDTO convertToDto(Optional<CharacterSheet> characterSheet) {
        if (characterSheet.isPresent()) {
            CharacterSheet sheet = characterSheet.get();
            return modelMapper.map(sheet, CharacterSheetDTO.class);
        } else {
            throw new NoSuchElementException("Personagem não encontrado");
        }
    }

    public CharacterSheet save(final String email, final CharacterSheet characterSheet) {
       //Optional<CharClass> charClass = classesRepository.findById(characterSheet.getCharClass().getId());
//TODO: Criar sequencia para pegar a classe, atributos nao serao necessarios, uma vez que fe fara isso

        //characterSheet.setHitPoints(calcInitialHT(charClass.get().getHitDice(), convertAttribute(characterSheet.getConstitution())));
        characterSheet.setEmail(email);
        return charactersRepository.save(characterSheet);
    }

}
