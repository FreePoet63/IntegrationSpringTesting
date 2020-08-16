package com.superheroes.resourse;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroesRepository extends JpaRepository<Heroes, Integer> {

}
