package ced.characters.management.controller;

import ced.characters.management.helper.JwtHelper;
import ced.characters.management.models.CharacterSheet;
import ced.characters.management.repository.CharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/characters")
public class CharController {

    private final CharactersRepository charactersRepository;

    @Autowired
    public CharController(CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }

    @GetMapping("/")
    public String version(){
        return "1.0.4";
    }

    @GetMapping("/list")
    public ResponseEntity<List<CharacterSheet>> list(@RequestHeader(value = "Authorization", required = false) final String authorization){
       return ResponseEntity.status(HttpStatus.OK).body(charactersRepository.findAllByLogin(JwtHelper.findUser(authorization)));
    }

}
