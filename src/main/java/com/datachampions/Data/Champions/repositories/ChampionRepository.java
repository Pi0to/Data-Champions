package com.datachampions.Data.Champions.repositories;

import com.datachampions.Data.Champions.entities.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, String> {
}
