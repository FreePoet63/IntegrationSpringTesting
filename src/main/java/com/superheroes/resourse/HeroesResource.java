package com.superheroes.resourse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/all")
public class HeroesResource {
    private HeroesRepository heroesRepository;

    public HeroesResource(HeroesRepository heroesRepository) {
        this.heroesRepository = heroesRepository;
    }
    @GetMapping("/")
    public List<Heroes> all() {
        return heroesRepository.findAll();
    }
}
