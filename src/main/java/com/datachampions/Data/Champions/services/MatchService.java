package com.datachampions.Data.Champions.services;

import com.datachampions.Data.Champions.entities.match.Match;
import com.datachampions.Data.Champions.repositories.MatchRepository;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match findById(String matchId) {
        return matchRepository.findById(matchId).orElseThrow(() -> new RuntimeException("Match not found"));
    }
}
