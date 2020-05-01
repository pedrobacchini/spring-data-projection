package com.github.pedrobacchini.springdataprojection.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.pedrobacchini.springdataprojection.json.View;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(View.NamesOnly.class)
    private String firstName;

    @JsonView(View.NamesOnly.class)
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
