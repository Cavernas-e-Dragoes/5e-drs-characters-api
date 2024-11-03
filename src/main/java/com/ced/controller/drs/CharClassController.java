package com.ced.controller.drs;

import com.ced.dto.Response;
import com.ced.dto.Summary;
import com.ced.model.drs.classes.CharClass;
import com.ced.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/classes")
public class CharClassController {

    @Autowired
    private ClassesRepository classesRepository;


    @GetMapping
    public ResponseEntity<Response> getAllClasses() {
        List<CharClass> classes = classesRepository.findAll();

        List<Summary> summaries = classes.stream()
                .map(cls -> new Summary(
                        cls.getIndex(),
                        cls.getName(),
                        "/api/classes/" + cls.getIndex()
                ))
                .collect(Collectors.toList());

        Response response = new Response(summaries.size(), summaries);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{index}")
    public ResponseEntity<CharClass> getClassByIndex(@PathVariable String index) {
        Optional<CharClass> charClass = classesRepository.findByIndex(index);
        return charClass.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
}
