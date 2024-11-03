package com.ced.controller.drs;

import com.ced.dto.Response;
import com.ced.dto.Summary;
import com.ced.model.drs.races.Race;
import com.ced.repository.RacesRepository;
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
@RequestMapping("/api/racas")
public class RaceController {

    @Autowired
    private RacesRepository racesRepository;

    @GetMapping
    public ResponseEntity<Response> getAllRaces() {
        List<Race> races = racesRepository.findAll();

        List<Summary> summaries = races.stream()
                .map(race -> new Summary(
                        race.getIndex(),
                        race.getName(),
                        "/api/racas/" + race.getIndex()
                ))
                .collect(Collectors.toList());

        Response response = new Response(summaries.size(), summaries);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{index}")
    public ResponseEntity<Race> getRaceByIndex(@PathVariable String index) {
        Optional<Race> race = racesRepository.findByIndex(index);
        return race.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
