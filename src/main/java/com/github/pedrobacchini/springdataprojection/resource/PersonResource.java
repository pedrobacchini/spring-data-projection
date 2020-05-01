package com.github.pedrobacchini.springdataprojection.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.pedrobacchini.springdataprojection.entity.Person;
import com.github.pedrobacchini.springdataprojection.json.View;
import com.github.pedrobacchini.springdataprojection.projection.NamesOnly;
import com.github.pedrobacchini.springdataprojection.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonResource {

    private final PersonRepository personRepository;

    @GetMapping("/{id}")
    @JsonView(View.NamesOnly.class)
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        return personRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/{id}", params = "projection")
    public ResponseEntity<NamesOnly> findByIdNames(@PathVariable Long id) {
        return personRepository.findByIdNames(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
