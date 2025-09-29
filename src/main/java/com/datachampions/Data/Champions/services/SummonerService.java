package com.datachampions.Data.Champions.services;

import com.datachampions.Data.Champions.repositories.SummonerRepository;
import org.springframework.stereotype.Service;

@Service
public class SummonerService {

    private final SummonerRepository summonerRepository;

    public SummonerService(SummonerRepository summonerRepository) {
        this.summonerRepository = summonerRepository;
    }

    public void findById(String id) {
        summonerRepository.findById(id);
    }
}
