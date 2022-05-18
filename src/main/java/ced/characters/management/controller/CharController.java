package ced.characters.management.controller;

import ced.characters.management.helper.JwtHelper;
import ced.characters.management.repository.CharactersRepository;
import ced.characters.management.service.CharactersService;
import ced.characters.management.vo.CharactersSheetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/characters")
public class CharController {

    private final CharactersService charactersService;

    @Autowired
    public CharController(CharactersService charactersService) {
        this.charactersService = charactersService;
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

}
