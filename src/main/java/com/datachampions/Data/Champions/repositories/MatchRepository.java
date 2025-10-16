package com.datachampions.Data.Champions.repositories;

import com.datachampions.Data.Champions.entities.match.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends JpaRepository<Match, String> {

    @Query("SELECT m.matchId FROM Match m WHERE m.matchId IN :matchIds")
    public List<String> findExistingIdsByMatchIdIn(@Param("matchIds") List<String> matchIds);

}
