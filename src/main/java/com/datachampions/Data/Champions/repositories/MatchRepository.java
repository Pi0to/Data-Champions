package com.datachampions.Data.Champions.repositories;

import com.datachampions.Data.Champions.entities.match.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, String> {

}
