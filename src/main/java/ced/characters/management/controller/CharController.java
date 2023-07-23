package ced.characters.management.controller;

import ced.characters.management.helper.JwtHelper;
import ced.characters.management.models.CharacterSheet;
import ced.characters.management.repository.CharactersRepository;
import ced.characters.management.service.CharactersService;
import ced.characters.management.vo.CharactersListSheetDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        return "1.3";
    }

    @GetMapping("/list")
    @CrossOrigin(origins = { "https://cavernasedragoes.com.br", "http://localhost:4200" })
    public ResponseEntity<List<CharactersListSheetDTO>> list(@RequestHeader(value = "Authorization", required = false)
                                                                 final String authorization) {
        final String login = JwtHelper.getLoginFromJWT(authorization);

        if (login.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ArrayList<>());
        }

        List<CharactersListSheetDTO> listSheetDTOS = charactersService.findAll(login);

        return ResponseEntity.status(HttpStatus.OK).body(listSheetDTOS);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = { "https://cavernasedragoes.com.br", "http://localhost:4200" })
    public ResponseEntity<CharacterSheet> getCharacter(@PathVariable final String id){
        return ResponseEntity.status(HttpStatus.OK).body(charactersService.findById(id));
    }

    @PostMapping
    @CrossOrigin(origins = { "https://cavernasedragoes.com.br", "http://localhost:4200" })
    public ResponseEntity<CharacterSheet> create(@RequestBody CharacterSheet characterSheet) {

        characterSheet = charactersService.save(characterSheet);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(characterSheet);
    }

    @PutMapping("/{name}")
    @CrossOrigin(origins = { "https://cavernasedragoes.com.br", "http://localhost:4200" })
    public ResponseEntity<?> update(@PathVariable String name,
                                       @RequestBody CharacterSheet newChar){

            Optional<CharacterSheet> actualChar = charactersRepository.findByName(name);

            if (actualChar.isPresent()) {
                BeanUtils.copyProperties(newChar, actualChar.get(),"id");
                actualChar = Optional.of(charactersRepository.save(actualChar.get()));
                return ResponseEntity.ok(actualChar);
            }
            return  ResponseEntity.notFound().build();
    }

}
