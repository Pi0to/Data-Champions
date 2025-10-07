package com.datachampions.Data.Champions.repositories;

import com.datachampions.Data.Champions.entities.rune.Rune;
import com.datachampions.Data.Champions.entities.sumonnerSpell.SummonerSpell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SSpellRepository extends JpaRepository<SummonerSpell, String> {

    Optional<SummonerSpell> findByKey(int key);
}
