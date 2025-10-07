package com.datachampions.Data.Champions.services;


import com.datachampions.Data.Champions.entities.champion.Champion;
import com.datachampions.Data.Champions.repositories.ChampionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionService {

    private final ChampionRepository championRepository;

    public ChampionService(ChampionRepository championRepository) {
        this.championRepository = championRepository;
    }

    @Transactional
    public void saveAll(List<Champion> champions) {
        championRepository.saveAll(champions);
    }

    public Champion findById(String id) {
        return championRepository.findById(id).orElseThrow(() -> new RuntimeException("Champion not found"));
    }

    public Champion findByName(String name) {
        return championRepository.findByName(name).orElseThrow(() -> new RuntimeException("Champion not found"));
    }
}
