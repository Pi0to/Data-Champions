package com.datachampions.Data.Champions.services;

import com.datachampions.Data.Champions.dto.importDto.MatchImportDto;
import com.datachampions.Data.Champions.entities.match.Match;
import com.datachampions.Data.Champions.entities.match.Participant;
import com.datachampions.Data.Champions.repositories.MatchRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    private static final Logger logger = LoggerFactory.getLogger(MatchService.class);

    private final MatchRepository matchRepository;
    private final RiotService riotService;

    public MatchService(MatchRepository matchRepository, RiotService riotService) {
        this.matchRepository = matchRepository;
        this.riotService = riotService;
    }

    public Match findById(String matchId) {
        return matchRepository.findById(matchId).orElseThrow(() -> new RuntimeException("Match not found"));
    }

    @Transactional
    public void processAndSaveMatch(String matchId) {
        logger.info(">>> [SERVICE] Recebi para processar o ID: '{}'", matchId);

        if(matchRepository.existsById(matchId)) {
            logger.info("Match with ID " + matchId + " already exists. Skipping.");
            return;
        }

        Match match = riotService.getMatchById(matchId);

        if(match == null){
            logger.warn("Match with ID " + matchId + " not found in Riot API.");
        }

        matchRepository.save(match);

        logger.info("Match with ID " + matchId + " saved successfully with " + match.getParticipants().size() + " participants.");


    }
}
