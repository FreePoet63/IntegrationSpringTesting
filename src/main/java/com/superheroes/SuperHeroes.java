package com.superheroes;

import com.superheroes.resourse.Heroes;
import com.superheroes.resourse.HeroesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SuperHeroes {
    public static void main(String[] args) {
        SpringApplication.run(SuperHeroes.class, args);
    }

    @Bean
    CommandLineRunner runner(HeroesRepository repository) {
        return args -> {
            repository.save(new Heroes(63, "Oleg", "26 febrary", "Minsk",
                    "engineer", "men", 6565788));

            repository.save(new Heroes(2, "Nata", "18 July", "Moscow",
                    "Doctor", "Woman", 7777777));
        };


    }


}