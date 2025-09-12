package com.datachampions.Data.Champions.repositories;

import com.datachampions.Data.Champions.entities.rune.Rune;
import com.datachampions.Data.Champions.entities.sumonnerSpell.SummonerSpell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SSpellRepository extends JpaRepository<SummonerSpell, String> {
}
