package com.ced.controller;


import com.ced.dto.CharacterDTO;
import com.ced.dto.CharactersListDTO;
import com.ced.model.Character;
import com.ced.service.CharactersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ced.constants.ApplicationConstants.AUTHENTICATED_EMAIL;
import static com.ced.constants.ApplicationConstants.BASE_API_PERSONAGENS;

@RestController
@RequestMapping(BASE_API_PERSONAGENS)
public class CharController {

    private final CharactersService charactersService;

    @Autowired
    public CharController(final CharactersService charactersService) {
        this.charactersService = charactersService;
    }

    @GetMapping()
    public ResponseEntity<List<CharactersListDTO>> list(HttpServletRequest request) {
        String email = (String) request.getAttribute(AUTHENTICATED_EMAIL);

        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<CharactersListDTO> listSheetDTOS = charactersService.findAll(email);

        return ResponseEntity.status(HttpStatus.OK).body(listSheetDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCharacter(HttpServletRequest request, @PathVariable final String id) {
        String email = (String) request.getAttribute(AUTHENTICATED_EMAIL);

        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized!");
        }

        try {
            CharacterDTO character = charactersService.findById(email, id);
            return ResponseEntity.ok(character);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> create(HttpServletRequest request, @RequestBody Character character) {
        String email = (String) request.getAttribute(AUTHENTICATED_EMAIL);

        if (email == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: Email not found in token.");
        }

        try {
            Character savedCharacter = charactersService.save(email, character);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCharacter);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
