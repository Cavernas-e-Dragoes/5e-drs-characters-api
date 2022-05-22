package ced.characters.management.service;

import ced.characters.management.helper.JwtHelper;
import ced.characters.management.models.CharClass;
import ced.characters.management.models.CharacterSheet;
import ced.characters.management.repository.CharClassRepository;
import ced.characters.management.repository.CharactersRepository;
import ced.characters.management.repository.RaceRepository;
import ced.characters.management.vo.CharacterSheetDTO;
import ced.characters.management.vo.CharactersListSheetDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ced.characters.management.helper.Calcs.calcInitialHT;
import static ced.characters.management.helper.Calcs.convertAttribute;

@Service
public class CharactersService {

    private final CharactersRepository charactersRepository;

    private final RaceRepository raceInterface;

    private final CharClassRepository charClassRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    public CharactersService(CharactersRepository charactersRepository, RaceRepository raceInterface, CharClassRepository charClassRepository) {
        this.charactersRepository = charactersRepository;
        this.raceInterface = raceInterface;
        this.charClassRepository = charClassRepository;
    }

    public List<CharactersListSheetDTO> findAll(String authorization) {

        String jwt = JwtHelper.findUser(authorization);

        assert jwt != null;
        List<CharactersListSheetDTO> charactersSheetDTOS = new ArrayList<>();

        if (jwt.isBlank()){
            return charactersSheetDTOS;
        }

        List<CharacterSheet> characterSheetList = charactersRepository.findAllByLogin(jwt);

        for (CharacterSheet characterSheet : characterSheetList) {

            CharactersListSheetDTO charactersSheetDTO = convertToDtoList(characterSheet);
            charactersSheetDTO.setRaceName(raceInterface.findById(characterSheet.getRace()).get().getName());
            charactersSheetDTO.setClassName(charClassRepository.findById(characterSheet.getCharClass()).get().getName());

            charactersSheetDTOS.add(charactersSheetDTO);
        }

        return charactersSheetDTOS;
    }

    public CharacterSheetDTO findById(Long id) {
        Optional<CharacterSheet> characterSheet = charactersRepository.findById(id);

        CharacterSheetDTO characterSheetDTO = convertToDto(characterSheet);
        characterSheetDTO.setRaceName(raceInterface.findById(characterSheet.get().getRace()).get().getName());

        Optional<CharClass> charClass = charClassRepository.findById(characterSheet.get().getCharClass());
        characterSheetDTO.setClassName(charClass.get().getName());

        characterSheetDTO.setStrengthModifier(convertAttribute(characterSheetDTO.getStrength()));
        characterSheetDTO.setDexterityModifier(convertAttribute(characterSheetDTO.getDexterity()));
        characterSheetDTO.setConstitutionModifier(convertAttribute(characterSheetDTO.getConstitution()));
        characterSheetDTO.setIntelligenceModifier(convertAttribute(characterSheetDTO.getConstitution()));
        characterSheetDTO.setWisdomModifier(convertAttribute(characterSheetDTO.getWisdom()));
        characterSheetDTO.setCharismaModifier(convertAttribute(characterSheetDTO.getCharisma()));

        return characterSheetDTO;
    }

    private CharactersListSheetDTO convertToDtoList(CharacterSheet characterSheet) {
        return modelMapper.map(characterSheet, CharactersListSheetDTO.class);
    }

    private CharacterSheetDTO convertToDto(Optional<CharacterSheet>  characterSheet) {
        return modelMapper.map(characterSheet, CharacterSheetDTO.class);
    }

    public CharacterSheet save(CharacterSheet characterSheet) {

        Optional<CharClass> charClass = charClassRepository.findById(characterSheet.getCharClass());

        characterSheet.setHitPoints(calcInitialHT(charClass.get().getHitDice(), convertAttribute(characterSheet.getConstitution())));

        return charactersRepository.save(characterSheet);
    }

}
