package ced.characters.management.service;

import ced.characters.management.helper.JwtHelper;
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

        List<CharacterSheet> characterSheetList = charactersRepository.findAllByLogin(JwtHelper.findUser(authorization));
        List<CharactersListSheetDTO> charactersSheetDTOS = new ArrayList<>();

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
        return convertToDto(characterSheet);
    }


    private CharactersListSheetDTO convertToDtoList(CharacterSheet characterSheet) {
        return modelMapper.map(characterSheet, CharactersListSheetDTO.class);
    }

    private CharacterSheetDTO convertToDto(Optional<CharacterSheet>  characterSheet) {
        return modelMapper.map(characterSheet, CharacterSheetDTO.class);
    }

}
