package com.github.pedrobacchini.springdataprojection.repository;

import com.github.pedrobacchini.springdataprojection.entity.Person;
import com.github.pedrobacchini.springdataprojection.projection.NamesOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(" select p from Person p where p.id = :id")
    Optional<NamesOnly> findByIdNames(Long id);
}
