package com.ced.controller.character;


import com.ced.model.character.CharacterSheet;
import com.ced.service.CharactersService;
import com.ced.utils.helper.JwtHelper;
import com.ced.vo.CharactersListSheetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/characters")
public class CharController {

    private final CharactersService charactersService;


    @Autowired
    public CharController(final CharactersService charactersService) {
        this.charactersService = charactersService;
    }

    @GetMapping("/")
    public String version() {
        return "Characters API 1.1.4";
    }

    @GetMapping("/list")
    @CrossOrigin(origins = {"https://nodejs-production-c9fc.up.railway.app/", "http://localhost:4200"})
    public ResponseEntity<List<CharactersListSheetDTO>> list(@RequestHeader(value = "Authorization", required = false) final String jwt) {
        final String email = JwtHelper.decodeToken(jwt);

        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<CharactersListSheetDTO> listSheetDTOS = charactersService.findAll(email);

        return ResponseEntity.status(HttpStatus.OK).body(listSheetDTOS);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = {"https://nodejs-production-c9fc.up.railway.app/", "http://localhost:4200"})
    public ResponseEntity<CharacterSheet> getCharacter(@RequestHeader(value = "Authorization", required = false) final String jwt, @PathVariable final String id) {
        final String email = JwtHelper.decodeToken(jwt);

        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(charactersService.findById(email, id));
    }

    @PostMapping
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    public ResponseEntity<CharacterSheet> create(@RequestHeader(value = "Authorization", required = false) final String jwt, @RequestBody CharacterSheet characterSheet) {

        final String email = JwtHelper.decodeToken(jwt);

        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        characterSheet = charactersService.save(email, characterSheet);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(characterSheet);
    }

/*
    @PutMapping("/{name}")
    @CrossOrigin(origins = { "https://nodejs-production-c9fc.up.railway.app/", "http://localhost:4200" })
    public ResponseEntity<?> update(@PathVariable String name,
                                       @RequestBody CharacterSheet newChar){

            Optional<CharacterSheet> actualChar = charactersRepository.findByName(name);

            if (actualChar.isPresent()) {
                BeanUtils.copyProperties(newChar, actualChar.get(),"id");
                actualChar = Optional.of(charactersRepository.save(actualChar.get()));
                return ResponseEntity.ok(actualChar);
            }
            return  ResponseEntity.notFound().build();
    }*/

}
