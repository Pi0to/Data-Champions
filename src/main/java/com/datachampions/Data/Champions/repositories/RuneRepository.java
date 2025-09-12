package com.datachampions.Data.Champions.repositories;

import com.datachampions.Data.Champions.entities.champion.Champion;
import com.datachampions.Data.Champions.entities.rune.Rune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuneRepository extends JpaRepository<Rune, Integer> {
}
