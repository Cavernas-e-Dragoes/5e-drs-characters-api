package com.ced.controller.drs;

import com.ced.dto.Response;
import com.ced.dto.Summary;
import com.ced.model.drs.spells.Spell;
import com.ced.repository.SpellsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/magias")
public class SpellController {

    @Autowired
    private SpellsRepository spellsRepository;


    @GetMapping
    public ResponseEntity<Response> getAllSpells() {
        List<Spell> spells = spellsRepository.findAll();

        List<Summary> summaries = spells.stream()
                .map(spell -> new Summary(
                        spell.getIndex(),
                        spell.getName(),
                        "/api/magias/" + spell.getIndex()
                ))
                .collect(Collectors.toList());

        Response response = new Response(summaries.size(), summaries);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{index}")
    public ResponseEntity<Spell> getSpellByIndex(@PathVariable String index) {
        Optional<Spell> spell = spellsRepository.findByIndex(index);
        return spell.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
