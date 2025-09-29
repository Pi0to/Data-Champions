package com.datachampions.Data.Champions.services;

import com.datachampions.Data.Champions.entities.summoner.Summoner;
import com.datachampions.Data.Champions.repositories.SummonerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class SummonerService {

    private final SummonerRepository summonerRepository;

    public SummonerService(SummonerRepository summonerRepository) {
        this.summonerRepository = summonerRepository;
    }


    @Transactional
    public Summoner findOrCreate(String puuid, String summonerName, String tagLine) {
        return summonerRepository.findById(puuid)
                .orElseGet(() -> {
                    Summoner newSummoner = new Summoner();
                    newSummoner.setPuuid(puuid);
                    newSummoner.setGameName(summonerName);
                    newSummoner.setTagLine(tagLine);
                    return summonerRepository.save(newSummoner);
                });
    }
}
