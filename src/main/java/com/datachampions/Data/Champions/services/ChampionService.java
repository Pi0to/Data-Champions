package com.datachampions.Data.Champions.services;


import com.datachampions.Data.Champions.entities.Champion;
import com.datachampions.Data.Champions.repositories.ChampionRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
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
}
