package com.datachampions.Data.Champions.services;

import com.datachampions.Data.Champions.entities.summoner.Summoner;
import com.datachampions.Data.Champions.repositories.SummonerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SummonerService {

    private final SummonerRepository summonerRepository;
    private final ObjectMapper objectMapper;

    public SummonerService(SummonerRepository summonerRepository, ObjectMapper objectMapper) {
        this.summonerRepository = summonerRepository;
        this.objectMapper = objectMapper;
    }

    public Summoner findByPuuid(String puuid) {
        return summonerRepository.findById(puuid).orElseThrow(() -> new RuntimeException("Summoner not found"));
    }


    @Transactional
    public Summoner findOrCreate(Summoner summoner) {
        return summonerRepository.findById(summoner.getPuuid())
                .orElseGet(() -> {
                    Summoner newSummoner = summoner;

                    return summonerRepository.save(newSummoner);
                });
    }

    public Summoner toEntity(String responseBody) {
        try {
            return objectMapper.readValue(responseBody, Summoner.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
