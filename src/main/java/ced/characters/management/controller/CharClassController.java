package ced.characters.management.controller;

import ced.characters.management.models.CharClass;
import ced.characters.management.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/api/classes")
public class CharClassController {


    private final ClassesRepository classesRepository;

    @Autowired
    public CharClassController(final ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }

    @GetMapping("/")
    public String version(){
        return "1.0";
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = { "https://cavernasedragoes.com.br", "http://localhost:4200" })
    public ResponseEntity<Optional<CharClass>> getCharacter(@PathVariable final String id){
        return ResponseEntity.status(HttpStatus.OK).body(classesRepository.findById(id));
    }

}
