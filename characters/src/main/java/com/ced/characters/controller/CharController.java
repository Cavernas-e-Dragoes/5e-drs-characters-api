package com.ced.characters.controller;


import com.ced.characters.models.CharacterSheet;
import com.ced.characters.repository.CharactersRepository;
import com.ced.characters.service.CharactersService;
import com.ced.characters.vo.CharactersListSheetDTO;
import com.ced.utils.helper.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @CrossOrigin(origins = { "https://nodejs-production-c9fc.up.railway.app/", "http://localhost:4200" })
    public ResponseEntity<List<CharactersListSheetDTO>> list(@RequestHeader(value = "Authorization", required = false)
                                                                 final String jwt) {
        final String email = JwtHelper.decodeToken(jwt);

        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<CharactersListSheetDTO> listSheetDTOS = charactersService.findAll(email);

        return ResponseEntity.status(HttpStatus.OK).body(listSheetDTOS);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = { "https://nodejs-production-c9fc.up.railway.app/", "http://localhost:4200" })
    public ResponseEntity<CharacterSheet> getCharacter(@RequestHeader(value = "Authorization", required = false)
                                                           final String jwt, @PathVariable final String id){
        final String email = JwtHelper.decodeToken(jwt);

        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(charactersService.findById(email, id));
    }

    @PostMapping
    @CrossOrigin(origins = { "http://localhost:8080", "http://localhost:4200" })
    public ResponseEntity<CharacterSheet> create(@RequestHeader(value = "Authorization", required = false)
                                                     final String jwt, @RequestBody CharacterSheet characterSheet) {

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
