package ced.characters.management.service;

import ced.characters.management.models.CharClass;
import ced.characters.management.models.CharacterSheet;
import ced.characters.management.repository.CharactersRepository;
import ced.characters.management.repository.ClassesRepository;
import ced.characters.management.vo.CharacterSheetDTO;
import ced.characters.management.vo.CharactersListSheetDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static ced.characters.management.helper.Calcs.*;


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

    public List<CharactersListSheetDTO> findAll(final String login) {

        List<CharactersListSheetDTO> charactersSheetDTOS = new ArrayList<>();

        List<CharacterSheet> characterSheetList = charactersRepository.findAllByLogin(login);

        for (CharacterSheet characterSheet : characterSheetList) {

            CharactersListSheetDTO charactersSheetDTO = convertToDtoList(characterSheet);
            charactersSheetDTO.setRaceName(characterSheet.getRace().getName());
            charactersSheetDTO.setClassName(characterSheet.getCharClass().getName());

            charactersSheetDTOS.add(charactersSheetDTO);
        }

        return charactersSheetDTOS;
    }

    public CharacterSheetDTO findById(String id) {
        Optional<CharacterSheet> characterSheet = charactersRepository.findById(id);

        CharacterSheetDTO characterSheetDTO = convertToDto(characterSheet);

        characterSheetDTO.setStrengthModifier(convertAttribute(characterSheetDTO.getStrength()));
        characterSheetDTO.setDexterityModifier(convertAttribute(characterSheetDTO.getDexterity()));
        characterSheetDTO.setConstitutionModifier(convertAttribute(characterSheetDTO.getConstitution()));
        characterSheetDTO.setIntelligenceModifier(convertAttribute(characterSheetDTO.getConstitution()));
        characterSheetDTO.setWisdomModifier(convertAttribute(characterSheetDTO.getWisdom()));
        characterSheetDTO.setCharismaModifier(convertAttribute(characterSheetDTO.getCharisma()));

        characterSheetDTO.setProficiencyBonus(getProficiencyBonus(characterSheetDTO.getLevel()));

        return characterSheetDTO;
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

    public CharacterSheet save(CharacterSheet characterSheet) {
        Optional<CharClass> charClass = classesRepository.findById(characterSheet.getCharClass().getId());

        characterSheet.setHitPoints(calcInitialHT(charClass.get().getHitDice(), convertAttribute(characterSheet.getConstitution())));
        return charactersRepository.save(characterSheet);
    }

}
