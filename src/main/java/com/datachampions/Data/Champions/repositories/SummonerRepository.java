package com.datachampions.Data.Champions.repositories;

import com.datachampions.Data.Champions.entities.champion.Champion;
import com.datachampions.Data.Champions.entities.summoner.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummonerRepository extends JpaRepository<Summoner, String> {
}
