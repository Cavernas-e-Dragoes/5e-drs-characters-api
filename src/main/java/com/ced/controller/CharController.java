package com.ced.controller;


import com.ced.dto.CharactersListSheetDTO;
import com.ced.model.Character;
import com.ced.security.JwtHelper;
import com.ced.service.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personagens")
public class CharController {

    private final CharactersService charactersService;

    @Autowired
    public CharController(final CharactersService charactersService) {
        this.charactersService = charactersService;
    }

    @GetMapping
    public ResponseEntity<List<CharactersListSheetDTO>> list(@RequestHeader(value = "Authorization", required = false) final String jwt) {
        final String email = JwtHelper.decodeToken(jwt);

        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<CharactersListSheetDTO> listSheetDTOS = charactersService.findAll(email);

        return ResponseEntity.status(HttpStatus.OK).body(listSheetDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacter(@RequestHeader(value = "Authorization", required = false) final String jwt, @PathVariable final String id) {
        final String email = JwtHelper.decodeToken(jwt);

        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(charactersService.findById(email, id));
    }

    @PostMapping
    public ResponseEntity<Character> create(@RequestHeader(value = "Authorization", required = false) final String jwt, @RequestBody Character character) {

        final String email = JwtHelper.decodeToken(jwt);

        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        character = charactersService.save(email, character);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(character);
    }
}
