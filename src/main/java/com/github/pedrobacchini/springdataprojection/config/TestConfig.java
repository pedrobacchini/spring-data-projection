package com.github.pedrobacchini.springdataprojection.config;

import com.github.pedrobacchini.springdataprojection.entity.Person;
import com.github.pedrobacchini.springdataprojection.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Bean
    CommandLineRunner instantiateDatabase(final PersonRepository personRepository) {
        return args -> personRepository.save(new Person("Pedro", "Bacchini"));
    }
}
