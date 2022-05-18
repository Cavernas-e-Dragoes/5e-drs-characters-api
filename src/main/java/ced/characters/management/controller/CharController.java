package ced.characters.management.controller;

import ced.characters.management.models.CharacterSheet;
import ced.characters.management.repository.CharactersRepository;
import ced.characters.management.service.CharactersService;
import ced.characters.management.vo.CharactersSheetDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/characters")
public class CharController {

    private final CharactersService charactersService;

    private final CharactersRepository charactersRepository;

    @Autowired
    public CharController(CharactersService charactersService, CharactersRepository charactersRepository) {
        this.charactersService = charactersService;
        this.charactersRepository = charactersRepository;
    }

    @GetMapping("/")
    public String version(){
        return "1.0.6";
    }

    @GetMapping("/list")
    public ResponseEntity<List<CharactersSheetDTO>> list(@RequestHeader(value = "Authorization", required = false) final String authorization){
        System.out.println("hmm");
       return ResponseEntity.status(HttpStatus.OK).body(charactersService.findAll(authorization));
    }

    @PostMapping
    public ResponseEntity<CharacterSheet> create(@RequestBody CharacterSheet characterSheet) {
        characterSheet = charactersRepository.save(characterSheet);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(characterSheet);
    }

    @PutMapping("/{name}")
    public ResponseEntity<?> update(@PathVariable String name,
                                       @RequestBody CharacterSheet newChar){

            Optional<CharacterSheet> actualChar = charactersRepository.findByName(name);

            if (actualChar.isPresent()) {
                BeanUtils.copyProperties(newChar, actualChar.get(),"id");
                actualChar = Optional.ofNullable(charactersRepository.save(actualChar.get()));
                return ResponseEntity.ok(actualChar);
            }
            return  ResponseEntity.notFound().build();
    }

}
